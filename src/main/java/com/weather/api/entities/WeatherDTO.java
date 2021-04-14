package com.weather.api.entities;

public class WeatherDTO {
    private Long id;
    private String name;
    private Long dt;

    public WeatherDTO() {
    }

    public WeatherDTO(Long id, String name, Long dt) {
        this.id = id;
        this.name = name;
        this.dt = dt;
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

    public Long getDt() {
        return dt;
    }

    public void setDt(Long dt) {
        this.dt = dt;
    }
}
