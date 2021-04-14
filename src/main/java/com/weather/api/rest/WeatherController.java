package com.weather.api.rest;

import com.weather.api.consume.WeatherService;
import com.weather.api.entities.WeatherDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather/")
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @GetMapping
    public WeatherDTO getWeatherByCity() {
        return weatherService.getOne();
    }

}
