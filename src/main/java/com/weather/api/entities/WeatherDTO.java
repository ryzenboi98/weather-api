package com.weather.api.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.lang.reflect.Array;
import java.util.List;

public class WeatherDTO {
    private Long id;
    private String name;

    @JsonProperty("dt")
    private Long date;

    @JsonProperty("coord")
    private Coordinates coordinates;

    @JsonProperty("main")
    private WeatherTemp weatherTemp;

    @JsonProperty("weather")
    private List<WeatherInfo> weatherInfo;

    public WeatherDTO() {
    }

    public WeatherDTO(Long id, String name, Long date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }
}
