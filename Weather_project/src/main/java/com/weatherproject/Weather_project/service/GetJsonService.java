package com.weatherproject.Weather_project.service;

import com.google.gson.Gson;
import com.weatherproject.Weather_project.dto.WeatherDto;
import com.weatherproject.Weather_project.model.WeatherData;
import com.weatherproject.Weather_project.repository.WeatherProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetJsonService {
    private final WeatherService weatherProjectService;
    private final WeatherProjectRepository weather_projectRepository;
    private final Gson gsonDeserialization;

    @Autowired
    public GetJsonService(WeatherService weatherProjectService, WeatherProjectRepository weatherProjectRepository,
                          Gson gsonDeserialization) {
        this.weatherProjectService = weatherProjectService;
        this.weather_projectRepository = weatherProjectRepository;
        this.gsonDeserialization = gsonDeserialization;
    }

    public void processJsonData(String city) {
        String jsonData = weatherProjectService.getWeatherFromApi(city);
        WeatherDto currentWeatherDto = gsonDeserialization.fromJson(jsonData, WeatherDto.class);
        WeatherData currentWeatherData = new WeatherData();
        currentWeatherData.setName(currentWeatherDto.getLocation().getName());
        currentWeatherData.setCountry(currentWeatherDto.getLocation().getCountry());
        currentWeatherData.setLast_updated(currentWeatherDto.getCurrent().getLast_updated());
        currentWeatherData.setTemp_c(String.valueOf(currentWeatherDto.getCurrent().getTemp_c()));
        weather_projectRepository.save(currentWeatherData);
    }
}
