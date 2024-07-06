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

}
