package com.weather.api.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.api.consume.WeatherService;
import com.weather.api.entities.WeatherDTO;
import com.weather.api.exceptions.LocationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;

@RestController
@RequestMapping("/weather/")
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @Autowired
    private ObjectMapper mapper;

    //

    @GetMapping
    public WeatherDTO getWeatherByCity(@RequestParam("location") String location) {
        return weatherService.getOne(location);
    }
}
