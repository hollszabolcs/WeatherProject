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
    private List<ForecastDayDTO> forecastday;


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
    public static class ForecastDayDTO {
        @Expose
        private String date;
        @Expose
        private DayDTO dayDTO;
    }

    @Data
    public static class DayDTO {
        @Expose
        private double avgtemp_c;
    }

}
