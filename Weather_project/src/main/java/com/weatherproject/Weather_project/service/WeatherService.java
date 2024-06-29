package com.weatherproject.Weather_project.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;


@Service
public class WeatherService {
    private final RestTemplate restTemplate;
@Value("${Weather_project.api.key}:")
    private String apiKey;
    public WeatherService(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }

    public String getWeatherFromApi(String city) {
        final var apiUrl = URI.create(apiKey + city + "&days=3&aqi=no&alerts=no");
        return restTemplate.getForObject(apiUrl, String.class);
    }
}
