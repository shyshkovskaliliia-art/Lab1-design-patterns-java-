package com.patterns.structural.proxy;

public abstract class WeatherApi {
    public ApiResponse getCurrentWeather(String city) {
        return null;
    }

    public abstract ApiResponse getForecast(String city, int days);

    ApiResponse getAirQuality(String city) {
        return null;
    }
}
