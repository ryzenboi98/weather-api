package com.weather.api.entities.weather;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class WeatherDTO {
    private String location;

    @JsonProperty("current")
    private CurrentWeather currentWeather;

    @JsonProperty("hourly")
    private List<HourlyWeather> hourlyWeathers;

    @JsonProperty("daily")
    private List<DailyWeather> dailyWeathers;

    public WeatherDTO() {

    }

    public WeatherDTO(CurrentWeather currentWeather, List<HourlyWeather> hourlyWeathers, List<DailyWeather> dailyWeathers) {
        this.currentWeather = currentWeather;
        this.hourlyWeathers = hourlyWeathers;
        this.dailyWeathers = dailyWeathers;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public CurrentWeather getCurrentWeather() {
        return currentWeather;
    }

    public void setCurrentWeather(CurrentWeather currentWeather) {
        this.currentWeather = currentWeather;
    }

    public List<HourlyWeather> getHourlyWeathers() {
        return hourlyWeathers;
    }

    public void setHourlyWeathers(List<HourlyWeather> hourlyWeathers) {
        this.hourlyWeathers = hourlyWeathers;
    }

    public List<DailyWeather> getDailyWeathers() {
        return dailyWeathers;
    }

    public void setDailyWeathers(List<DailyWeather> dailyWeathers) {
        this.dailyWeathers = dailyWeathers;
    }
}
