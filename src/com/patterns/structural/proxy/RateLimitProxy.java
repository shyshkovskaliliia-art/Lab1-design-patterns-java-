package com.patterns.structural.proxy;

public class RateLimitProxy implements WeatherApi {
    private final WeatherApi target;
    private final int        maxRequestsPerMinute;

    private int  requestCount = 0;
    private long windowStart  = System.currentTimeMillis();

    private int totalAllowed  = 0;
    private int totalBlocked  = 0;

    public RateLimitProxy(WeatherApi target, int maxRequestsPerMinute) {
        this.target               = target;
        this.maxRequestsPerMinute = maxRequestsPerMinute;
    }

    @Override
    public ApiResponse getCurrentWeather(String city) {
        return guard(() -> target.getCurrentWeather(city), "/weather/" + city);
    }

    @Override
    public ApiResponse getForecast(String city, int days) {
        return guard(() -> target.getForecast(city, days),
                "/forecast/" + city + "?days=" + days);
    }

    @Override
    public ApiResponse getAirQuality(String city) {
        return guard(() -> target.getAirQuality(city), "/air-quality/" + city);
    }

    private ApiResponse guard(java.util.function.Supplier<ApiResponse> call,
                              String endpoint) {
        resetWindowIfNeeded();

        if (requestCount >= maxRequestsPerMinute) {
            totalBlocked++;
            long retryAfter = 60 - (System.currentTimeMillis() - windowStart) / 1000;
            System.out.printf("  [RateLimit] 429 BLOCKED %s (ліміт %d/хв, retry-after: %d с)%n",
                    endpoint, maxRequestsPerMinute, retryAfter);
            return new ApiResponse(429,
                    "{\"error\":\"Too Many Requests\",\"retryAfter\":" + retryAfter + "}",
                    "RATE_LIMIT", 0L);
        }

        requestCount++;
        totalAllowed++;
        System.out.printf("  [RateLimit] OK %s (запит %d/%d у поточному вікні)%n",
                endpoint, requestCount, maxRequestsPerMinute);
        return call.get();
    }

    private void resetWindowIfNeeded() {
        long now = System.currentTimeMillis();
        if (now - windowStart >= 60_000L) {
            windowStart  = now;
            requestCount = 0;
            System.out.println("  [RateLimit] Нове вікно обліку — лічильник скинуто");
        }
    }

    public void printStats() {
        System.out.printf("  [RateLimit] Пропущено: %d | Заблоковано: %d | Ліміт: %d/хв%n",
                totalAllowed, totalBlocked, maxRequestsPerMinute);
    }
}
