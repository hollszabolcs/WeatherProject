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
    private final Gson gson;

    @Autowired
    public GetJsonService(WeatherService weatherProjectService, WeatherProjectRepository weatherProjectRepository,
                          Gson gsonDeserialization) {
        this.weatherProjectService = weatherProjectService;
        this.weather_projectRepository = weatherProjectRepository;
        this.gson = gsonDeserialization;
    }

    public WeatherData processJsonData(String city) {
        String jsonData = weatherProjectService.getWeatherFromApi(city);
        WeatherData currentWeatherData = new WeatherData();
        WeatherDto currentWeatherDto = gson.fromJson(jsonData, WeatherDto.class);
        currentWeatherData.setName(currentWeatherDto.getLocation().getName());
        currentWeatherData.setCountry(currentWeatherDto.getLocation().getCountry());
        currentWeatherData.setLast_updated(currentWeatherDto.getCurrent().getLast_updated());
        currentWeatherData.setTemp_c(String.valueOf(currentWeatherDto.getCurrent().getTemp_c()));
        currentWeatherData.setIcon(currentWeatherDto.getCurrent().getCondition().getIcon());
        currentWeatherData.setText(currentWeatherDto.getCurrent().getCondition().getText());
        for (Object forecastDayDTO : currentWeatherDto.getForecast().getForecastday()) {
            WeatherDto.ForecastDay forecastDto =(WeatherDto.ForecastDay) forecastDayDTO;
            WeatherData forecastWeatherData = new WeatherData();
            forecastWeatherData.setName(currentWeatherDto.getLocation().getName());
            forecastWeatherData.setCountry(currentWeatherDto.getLocation().getCountry());
            forecastWeatherData.setLast_updated(forecastDto.getDate());
            forecastWeatherData.setTemp_c(String.valueOf(forecastDto.getDay().getAvgtemp_c()));
            weather_projectRepository.save(currentWeatherData);
        }
        return currentWeatherData;
    }
}