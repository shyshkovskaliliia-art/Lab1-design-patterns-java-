package com.patterns.structural.proxy;

import java.util.Set;

public class AuthProxy implements WeatherApi{
    private final WeatherApi target;
    private final String     apiKey;

    // Валідні ключі та їх рівні
    private static final Set<String> FREE_KEYS    = Set.of("FREE-001", "FREE-002");
    private static final Set<String> PREMIUM_KEYS = Set.of("PREM-GOLD", "PREM-CORP");

    public AuthProxy(WeatherApi target, String apiKey) {
        this.target = target;
        this.apiKey = apiKey;
    }

    @Override
    public ApiResponse getCurrentWeather(String city) {
        if (!isValidKey()) return unauthorized();
        System.out.println("  [Auth] Ключ " + maskedKey() + " — дозволено /weather");
        return target.getCurrentWeather(city);
    }

    @Override
    public ApiResponse getForecast(String city, int days) {
        if (!isValidKey()) return unauthorized();
        if (!isPremium()) return forbidden("/forecast — потрібен PREMIUM ключ");
        System.out.println("  [Auth] Ключ " + maskedKey() + " — дозволено /forecast");
        return target.getForecast(city, days);
    }

    @Override
    public ApiResponse getAirQuality(String city) {
        if (!isValidKey()) return unauthorized();
        if (!isPremium()) return forbidden("/air-quality — потрібен PREMIUM ключ");
        System.out.println("  [Auth] Ключ " + maskedKey() + " — дозволено /air-quality");
        return target.getAirQuality(city);
    }

    private boolean isValidKey() {
        return FREE_KEYS.contains(apiKey) || PREMIUM_KEYS.contains(apiKey);
    }

    private boolean isPremium() {
        return PREMIUM_KEYS.contains(apiKey);
    }

    private ApiResponse unauthorized() {
        System.out.println("  [Auth] ВІДХИЛЕНО — невідомий ключ: " + maskedKey());
        return new ApiResponse(401, "{\"error\":\"Unauthorized\",\"message\":\"Невалідний API-ключ\"}", "AUTH", 0L);
    }

    private ApiResponse forbidden(String reason) {
        System.out.println("  [Auth] ЗАБОРОНЕНО — " + reason);
        return new ApiResponse(403, "{\"error\":\"Forbidden\",\"message\":\"" + reason + "\"}", "AUTH", 0L);
    }

    private String maskedKey() {
        if (apiKey == null || apiKey.length() < 4) return "****";
        return apiKey.substring(0, 4) + "****";
    }
}
