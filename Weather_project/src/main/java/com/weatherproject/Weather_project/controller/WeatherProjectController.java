package com.weatherproject.Weather_project.controller;

import com.weatherproject.Weather_project.model.WeatherData;
import com.weatherproject.Weather_project.service.GetJsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherProjectController {
    @Autowired
    private final GetJsonService getJsonService;


    @Autowired
    public WeatherProjectController(GetJsonService getJsonService) {
        this.getJsonService = getJsonService;
    }

    @GetMapping("/printweatherdata")
    public String printWeatherData(@RequestParam String city) {
        try {
            WeatherData weatherData = getJsonService.processJsonData(city);

            if (weatherData != null) {
                StringBuilder response = new StringBuilder();
                response.append("City: ").append(weatherData.getName()).append("\n")
                        .append("Country: ").append(weatherData.getCountry()).append("\n")
                        .append("Last Updated: ").append(weatherData.getLastUpdated()).append("\n")
                        .append("Temperature (C): ").append(weatherData.getTempC()).append("\n")
                        .append("Condition Icon: ").append(weatherData.getIcon()).append("\n")
                        .append("Condition Text: ").append(weatherData.getText()).append("\n");
                return response.toString();
            } else {
                return "No weather data found for the specified city.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error during the retrieval: " + e.getMessage();
        }
    }

}
