package com.weatherproject.Weather_project.controller;

import com.weatherproject.Weather_project.service.GetJsonService;
import com.weatherproject.Weather_project.service.WeatherProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class WeatherProjectController {
    @Autowired
    private RestTemplate restTemplate;
    private final GetJsonService getJsonService;
    private final WeatherProjectService weatherProjectService;

    @Autowired
    public WeatherProjectController(GetJsonService getJsonService, WeatherProjectService weatherProjectService) {
        this.getJsonService = getJsonService;
        this.weatherProjectService = weatherProjectService;
    }

    @GetMapping("/weatherdata")
    String GetWeatherData(@RequestParam String city) {
        try {
            getJsonService.processJsonData(city);
            return "data has saved successfully";
        } catch (Exception e) {
            return "Error during the saving: " + e.getMessage();
        }
    }

}
