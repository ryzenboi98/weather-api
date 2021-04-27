package com.weather.api.entities.weather;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CurrentWeather {
    @JsonProperty("dt")
    private int date;

    private float temp;
    private float feels_like;
    private int humidity;
    private int clouds;
    private int wind_speed;

    @JsonProperty("weather")
    private List<WeatherInfo> weatherInfos;

    public CurrentWeather() {

    }

    public CurrentWeather(int date, float temp, float feels_like, int humidity, int clouds, int wind_speed, List<WeatherInfo> weatherInfos) {
        this.date = date;
        this.temp = temp;
        this.feels_like = feels_like;
        this.humidity = humidity;
        this.clouds = clouds;
        this.wind_speed = wind_speed;
        this.weatherInfos = weatherInfos;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(float feels_like) {
        this.feels_like = feels_like;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getClouds() {
        return clouds;
    }

    public void setClouds(int clouds) {
        this.clouds = clouds;
    }

    public int getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(int wind_speed) {
        this.wind_speed = wind_speed;
    }

    public List<WeatherInfo> getWeatherInfos() {
        return weatherInfos;
    }

    public void setWeatherInfos(List<WeatherInfo> weatherInfos) {
        this.weatherInfos = weatherInfos;
    }
}
