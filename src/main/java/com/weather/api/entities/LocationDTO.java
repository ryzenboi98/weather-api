package com.weather.api.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LocationDTO {
    private String name;

    @JsonProperty("coord")
    private Coordinates coordinates;

    @JsonProperty("sys")
    private Country country;

    public LocationDTO() {
    }

    public LocationDTO(String name, Coordinates coordinates, Country country) {
        this.name = name;
        this.coordinates = coordinates;
        this.country = country;
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
