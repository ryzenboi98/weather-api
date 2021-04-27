package com.weather.api.entities.weather;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DailyWeather {
    @JsonProperty("dt")
    private int date;

    @JsonProperty("temp")
    private TempInfo tempInfo;

    private int humidity;
    private int clouds;
    private int wind_speed;
    private float rain;

    @JsonProperty("weather")
    private List<WeatherInfo> weatherInfos;

    public DailyWeather() {

    }

    public DailyWeather(int date, TempInfo tempInfo, int humidity, int clouds, int wind_speed, float rain, List<WeatherInfo> weatherInfos) {
        this.date = date;
        this.tempInfo = tempInfo;
        this.humidity = humidity;
        this.clouds = clouds;
        this.wind_speed = wind_speed;
        this.rain = rain;
        this.weatherInfos = weatherInfos;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public TempInfo getTempInfo() {
        return tempInfo;
    }

    public void setTempInfo(TempInfo tempInfo) {
        this.tempInfo = tempInfo;
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

    public float getRain() {
        return rain;
    }

    public void setRain(float rain) {
        this.rain = rain;
    }

    public List<WeatherInfo> getWeatherInfos() {
        return weatherInfos;
    }

    public void setWeatherInfos(List<WeatherInfo> weatherInfos) {
        this.weatherInfos = weatherInfos;
    }
}
