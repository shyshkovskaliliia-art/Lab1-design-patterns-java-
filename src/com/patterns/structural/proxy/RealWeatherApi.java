package com.patterns.structural.proxy;

import java.util.Map;
import java.util.Random;

public class RealWeatherApi extends WeatherApi {
    private static final Random rng = new Random(42);

    private static final Map<String, String> WEATHER_DATA = Map.of(
            "Київ",    "{\"city\":\"Київ\",\"temp\":\"8°C\",\"condition\":\"Хмарно\",\"wind\":\"12 км/год\"}",
            "Львів",   "{\"city\":\"Львів\",\"temp\":\"5°C\",\"condition\":\"Дощ\",\"wind\":\"18 км/год\"}",
            "Одеса",   "{\"city\":\"Одеса\",\"temp\":\"14°C\",\"condition\":\"Ясно\",\"wind\":\"9 км/год\"}",
            "Харків",  "{\"city\":\"Харків\",\"temp\":\"6°C\",\"condition\":\"Сніг\",\"wind\":\"22 км/год\"}",
            "Дніпро",  "{\"city\":\"Дніпро\",\"temp\":\"7°C\",\"condition\":\"Туман\",\"wind\":\"5 км/год\"}"
    );

    private static final Map<String, String> FORECAST_DATA = Map.of(
            "Київ",  "{\"city\":\"Київ\",\"forecast\":[{\"day\":1,\"temp\":\"9°C\"},{\"day\":2,\"temp\":\"11°C\"},{\"day\":3,\"temp\":\"7°C\"}]}",
            "Львів", "{\"city\":\"Львів\",\"forecast\":[{\"day\":1,\"temp\":\"6°C\"},{\"day\":2,\"temp\":\"8°C\"},{\"day\":3,\"temp\":\"10°C\"}]}",
            "Одеса", "{\"city\":\"Одеса\",\"forecast\":[{\"day\":1,\"temp\":\"15°C\"},{\"day\":2,\"temp\":\"16°C\"},{\"day\":3,\"temp\":\"13°C\"}]}"
    );

    private static final Map<String, String> AIR_DATA = Map.of(
            "Київ",   "{\"city\":\"Київ\",\"aqi\":72,\"pm25\":\"18 мкг/м³\",\"quality\":\"Помірна\"}",
            "Львів",  "{\"city\":\"Львів\",\"aqi\":45,\"pm25\":\"10 мкг/м³\",\"quality\":\"Хороша\"}",
            "Одеса",  "{\"city\":\"Одеса\",\"aqi\":38,\"pm25\":\"8 мкг/м³\",\"quality\":\"Хороша\"}",
            "Харків", "{\"city\":\"Харків\",\"aqi\":91,\"pm25\":\"28 мкг/м³\",\"quality\":\"Погана\"}"
    );

    @Override
    public ApiResponse getCurrentWeather(String city) {
        long latency = simulateNetworkDelay();
        String body = WEATHER_DATA.getOrDefault(city,
                "{\"error\":\"Місто не знайдено\",\"city\":\"" + city + "\"}");
        int code = WEATHER_DATA.containsKey(city) ? 200 : 404;
        System.out.println("  [RealAPI] GET /weather/" + city + " → " + code + " (" + latency + " мс)");
        return new ApiResponse(code, body, "LIVE", latency);
    }

    @Override
    public ApiResponse getForecast(String city, int days) {
        long latency = simulateNetworkDelay();
        String body = FORECAST_DATA.getOrDefault(city,
                "{\"error\":\"Місто не знайдено\",\"city\":\"" + city + "\"}");
        int code = FORECAST_DATA.containsKey(city) ? 200 : 404;
        System.out.println("  [RealAPI] GET /forecast/" + city + "?days=" + days + " → " + code + " (" + latency + " мс)");
        return new ApiResponse(code, body, "LIVE", latency);
    }

    @Override
    public ApiResponse getAirQuality(String city) {
        long latency = simulateNetworkDelay();
        String body = AIR_DATA.getOrDefault(city,
                "{\"error\":\"Дані відсутні\",\"city\":\"" + city + "\"}");
        int code = AIR_DATA.containsKey(city) ? 200 : 404;
        System.out.println("  [RealAPI] GET /air-quality/" + city + " → " + code + " (" + latency + " мс)");
        return new ApiResponse(code, body, "LIVE", latency);
    }

    private long simulateNetworkDelay() {
        long delay = 200 + rng.nextInt(400);
        try { Thread.sleep(delay); } catch (InterruptedException ignored) {}
        return delay;
    }
}
