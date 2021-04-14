package com.weather.api.entities;

public class WeatherTemp {
    private float temp;
    private float humidity;

    public WeatherTemp() {
    }

    public WeatherTemp(float temp, float humidity) {
        this.temp = temp;
        this.humidity = humidity;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }
}
