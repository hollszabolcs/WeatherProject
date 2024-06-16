package com.weatherproject.Weather_project.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;


@Service
public class WeatherService {
    private final RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }

    public String getWeatherFromApi(String city) {
        final var apiUrl = URI.create("http://api.weatherapi.com/v1/forecast.json?key=fc1bbbb39fb34507a2e112206240806&q=" + city + "&days=3&aqi=no&alerts=no");
        return restTemplate.getForObject(apiUrl, String.class);
    }

}
