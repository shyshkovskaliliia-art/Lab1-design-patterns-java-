package com.patterns.structural.proxy;

import java.util.HashMap;
import java.util.Map;

public class CachingProxy implements WeatherApi{
    private final WeatherApi            target;
    private final Map<String, CacheEntry> cache = new HashMap<>();

    private static final long WEATHER_TTL  =  60_000L;
    private static final long FORECAST_TTL = 600_000L;
    private static final long AIR_TTL      = 120_000L;

    // Статистика
    private int hits   = 0;
    private int misses = 0;

    public CachingProxy(WeatherApi target) {
        this.target = target;
    }

    @Override
    public ApiResponse getCurrentWeather(String city) {
        String key = "weather:" + city;
        return getOrFetch(key, WEATHER_TTL, () -> target.getCurrentWeather(city));
    }

    @Override
    public ApiResponse getForecast(String city, int days) {
        String key = "forecast:" + city + ":" + days;
        return getOrFetch(key, FORECAST_TTL, () -> target.getForecast(city, days));
    }

    @Override
    public ApiResponse getAirQuality(String city) {
        String key = "air:" + city;
        return getOrFetch(key, AIR_TTL, () -> target.getAirQuality(city));
    }

    private ApiResponse getOrFetch(String key, long ttl,
                                   java.util.function.Supplier<ApiResponse> fetcher) {
        CacheEntry entry = cache.get(key);

        if (entry != null && !entry.isExpired()) {
            hits++;
            System.out.println("  [Cache] HIT  «" + key + "» (ще "
                    + entry.remainingTtlSec() + " сек до інвалідації)");
            return new ApiResponse(
                    entry.getResponse().statusCode,
                    entry.getResponse().body,
                    "CACHE",
                    1L);
        }

        if (entry != null) {
            System.out.println("  [Cache] EXPIRED «" + key + "» — оновлюємо");
        } else {
            System.out.println("  [Cache] MISS «" + key + "» — звертаємося до API");
        }

        misses++;
        ApiResponse fresh = fetcher.get();
        if (fresh.statusCode == 200) {
            cache.put(key, new CacheEntry(fresh, ttl));
            System.out.println("  [Cache] STORED «" + key + "» TTL=" + (ttl / 1000) + "с");
        }
        return fresh;
    }

    public void invalidate(String city) {
        cache.entrySet().removeIf(e -> e.getKey().contains(":" + city));
        System.out.println("  [Cache] INVALIDATED усі записи для «" + city + "»");
    }

    public void printStats() {
        int total = hits + misses;
        double hitRate = total > 0 ? (double) hits / total * 100 : 0;
        System.out.printf("  [Cache] Статистика: hits=%d, misses=%d, hit rate=%.1f%%, записів у кеші=%d%n",
                hits, misses, hitRate, cache.size());
    }
}
