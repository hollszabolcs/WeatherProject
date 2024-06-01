package com.weatherproject.Weather_project.dto;

import lombok.Data;

@Data
public class WeatherDto {
    private Location location;
    private Current current;

    @Data
    public static class Location {
        private String name;
        private String country;
    }

    @Data
    public static class Current {
        private String last_updated;
        private double temp_c;
    }
}
