package com.weather.api.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.api.consume.WeatherService;
import com.weather.api.crud.LocationCRUDActions;
import com.weather.api.entities.LocationDAO;
import com.weather.api.entities.LocationDTO;
import com.weather.api.repository.LocationRepository;
import org.apache.catalina.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/weather/")
public class WeatherController {

    @Autowired
    LocationCRUDActions locationCRUDActions;

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private ObjectMapper mapper;

    @GetMapping
    public LocationDAO getWeatherByCity(@RequestParam("location") String location) {
        LocationDTO locationDTO = weatherService.getLocation(location);

        List<LocationDAO> results = locationCRUDActions.
                findByNameAndCountry(
                        locationDTO.getName(),
                        locationDTO.getCountry().getName()
                );

        if (results.isEmpty())
            return locationCRUDActions.createLocation(locationDTO);
        else
            return results.get(0);
    }
}
