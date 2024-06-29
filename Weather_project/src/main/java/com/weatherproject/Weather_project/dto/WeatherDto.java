package com.weatherproject.Weather_project.dto;

import com.google.gson.annotations.Expose;
import lombok.Data;

import java.util.List;

@Data
public class WeatherDto {
    @Expose
    private Location location;
    @Expose
    private Current current;
    @Expose
    private Forecast forecast;


    @Data
    public static class Location {
        @Expose
        private String name;
        @Expose
        private String country;
        @Expose
        private Condition condition;

    }

    @Data
    public static class Current {
        @Expose
        private String last_updated;
        @Expose
        private double temp_c;
        @Expose
        private Condition condition;
    }

    @Data
    public static class Condition {
        @Expose
        private String text;
        @Expose
        private String icon;
    }

    @Data
    public static class ForecastDay {
        @Expose
        private String date;
        @Expose
        private Day day;
    }

    @Data
    public static class Day {
        @Expose
        private double avgtemp_c;
    }

    @Data
    public static class Forecast {
        private List<?> forecastday;
    }

}
