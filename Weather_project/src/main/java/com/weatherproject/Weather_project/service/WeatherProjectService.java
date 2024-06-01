package com.weatherproject.Weather_project.service;

import com.weatherproject.Weather_project.dto.WeatherDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;


@Service
public class WeatherProjectService {
    private final RestTemplate restTemplate;

    public WeatherProjectService(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }

    public String getWeatherFromApi(String city) {
        final var apiUrl = URI.create("http://api.weatherapi.com/v1/current.json?key=ac57493674af4b0ea86144110242005&q=" + city + "&api=no");
        return restTemplate.getForObject(apiUrl, String.class);
    }

}
