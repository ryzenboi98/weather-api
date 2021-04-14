package com.weather.api.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.weather.api.consume.WeatherService;

public class WeatherInfo {
    private Long id;

    @JsonProperty("main")
    private String info;

    private String description;
    private String icon;

    public WeatherInfo() {

    }

    public WeatherInfo(Long id, String info, String description, String icon) {
        this.id = id;
        this.info = info;
        this.description = description;
        this.icon = icon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
