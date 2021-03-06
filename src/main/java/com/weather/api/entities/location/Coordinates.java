package com.weather.api.entities.location;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Coordinates {
    @JsonProperty("lon")
    private float longitude;

    @JsonProperty("lat")
    private float latitude;

    public Coordinates() {
    }

    public Coordinates(float longitude, float latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }
}
