package com.weather.api.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.lang.reflect.Array;
import java.util.List;

public class WeatherDTO {
    private Long id;
    private String name;

    @JsonProperty("coord")
    private Coordinates coordinates;

    @JsonProperty("sys")
    private Country country;

    public WeatherDTO() {
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

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
