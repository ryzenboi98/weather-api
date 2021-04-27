package com.weather.api.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.api.consume.WeatherService;
import com.weather.api.crud.LocationCRUDActions;
import com.weather.api.entities.location.LocationDAO;
import com.weather.api.entities.location.LocationDTO;
import com.weather.api.entities.weather.WeatherDTO;
import com.weather.api.exceptions.LocationNotProvidedException;
import com.weather.api.rest.params.ParamsFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/weather/")
public class WeatherController {

    @Autowired
    LocationCRUDActions locationCRUDActions;

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private ParamsFormat paramsFormat;

    @Autowired
    private ObjectMapper mapper;

    @GetMapping
    public WeatherDTO getWeatherByCity(@RequestParam("location") String location) {
        WeatherDTO weatherDTO;
        LocationDAO locationDAO;

        // Transform the location request param format
        location = paramsFormat.fixformat(location);

        /* Check if the location provided already exists in the database */
        List<LocationDAO> results = locationCRUDActions.findByNameAndCountry(location);

        /* In case the location doesn't exist in DB */
        if(results.isEmpty()) {
            /* Get the result of the request to the Weather API */
            LocationDTO locationDTO = weatherService.getLocation(location);

            /* Check if the result is already in the DB */
            results = locationCRUDActions.findByNameAndCountry(locationDTO.getLocationCountry());

            /* In case the location doesn't exist in DB */
            if (results.isEmpty()) {
                /* Insert the location in the DB */
                locationDAO = locationCRUDActions.createLocation(locationDTO);

                /* Get the result of the weather info for the location provided */
                weatherDTO = weatherService.getWeather(locationDAO.getLatitude(), locationDAO.getLongitude());

                weatherDTO.setLocation(locationDAO.getNameCountry());
            } else {
                /* Get the result of the weather info for the location provided */
                weatherDTO = weatherService.getWeather(results.get(0).getLatitude(), results.get(0).getLongitude());

                weatherDTO.setLocation(results.get(0).getNameCountry());
            }
        } else {
            /* Get the result of the weather info for the location provided */
            weatherDTO = weatherService.getWeather(results.get(0).getLatitude(), results.get(0).getLongitude());

            weatherDTO.setLocation(results.get(0).getNameCountry());
        }

        return weatherDTO;
    }
}
