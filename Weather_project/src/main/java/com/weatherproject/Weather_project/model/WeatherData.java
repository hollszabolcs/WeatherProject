package com.weatherproject.Weather_project.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "weather_forecast")
public class WeatherData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String country;
    @Column(name = "last_updated")
    private String lastUpdated;
    @Column(name = "temp_c")
    private String tempC;
    @Transient
    private String icon;
    @Transient
    private String text;
    @Transient
    private String date;
    @Transient
    @Column(name = "avgtemp_c")
    private String avgTempC;

/*    @Data
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
    }*/

/*    @Data
    @Embeddable
    public static class Day {
        private String avgtemp_c;
    }*/
}
