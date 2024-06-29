package com.weatherproject.Weather_project.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "weather_forecast")
public class WeatherData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String country;
    private String last_updated;
    private String temp_c;
    @Transient
    private String icon;
    @Transient
    private String text;

    @OneToMany(mappedBy = "weatherData", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Transient
    private List<ForecastDay> forecastDays;

    @Data
    @Entity
    @Table(name = "forecast_day")
    public static class ForecastDay {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String date;

        @ManyToOne
        @JoinColumn(name = "weather_data_id")
        private WeatherData weatherData;

        @Embedded
        private Day day;
    }

    @Data
    @Embeddable
    public static class Day {
        private String avgtemp_c;
    }
    //TODO deal with naming convention
}
