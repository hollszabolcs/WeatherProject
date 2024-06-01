package com.weatherproject.Weather_project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;


@Service
@RequiredArgsConstructor
public class WeatherProjectService {
    private final RestTemplate restTemplate;

    public String getWeatherFromApi() {
        final var apiUrl = URI.create("http://api.weatherapi.com/v1/current.json?key=ac57493674af4b0ea86144110242005&q=" + "Kengyel" + "&api=no");
        return restTemplate.getForObject(apiUrl, String.class);
    }
}
