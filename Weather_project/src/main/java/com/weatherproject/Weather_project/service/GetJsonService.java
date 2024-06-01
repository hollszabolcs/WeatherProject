package com.weatherproject.Weather_project.service;

import com.google.gson.Gson;
import com.weatherproject.Weather_project.dto.WeatherDto;
import com.weatherproject.Weather_project.model.WeatherData;
import com.weatherproject.Weather_project.repository.WeatherProjectRepository;
import org.springframework.stereotype.Service;

@Service
public class GetJsonService {
    private final WeatherProjectService weatherProjectService;
    private final WeatherProjectRepository weather_projectRepository;

    public GetJsonService(WeatherProjectService weatherProjectService, WeatherProjectRepository weatherProjectRepository) {
        this.weatherProjectService = weatherProjectService;
        this.weather_projectRepository = weatherProjectRepository;
    }

    public void processJsonData() {
        String jsonData = weatherProjectService.getWeatherFromApi();
        Gson gson = new Gson();
        WeatherDto weatherdto = gson.fromJson(jsonData, WeatherDto.class);
        WeatherData weatherData = new WeatherData();
        weatherData.setName(weatherdto.getLocation().getName());
        weatherData.setCountry(weatherdto.getLocation().getCountry());
        weatherData.setLast_updated(weatherdto.getCurrent().getLast_updated());
        weatherData.setTemp_c(String.valueOf(weatherdto.getCurrent().getTemp_c()));
        weather_projectRepository.save(weatherData);
    }
}
