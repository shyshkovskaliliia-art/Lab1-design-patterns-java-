package com.patterns.structural.proxy;

public class WeatherApi {
    ApiResponse getCurrentWeather(String city);
    ApiResponse getForecast(String city, int days);
    ApiResponse getAirQuality(String city);
}
