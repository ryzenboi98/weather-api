package com.weather.api.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.api.consume.WeatherService;
import com.weather.api.entities.LocationDAO;
import com.weather.api.entities.LocationDTO;
import com.weather.api.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather/")
public class WeatherController {

    @Autowired
    LocationRepository locationRepo;

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private ObjectMapper mapper;

    @GetMapping
    public LocationDAO getWeatherByCity(@RequestParam("location") String location) {
        LocationDTO locationDTO = weatherService.getOne(location);

        LocationDAO locationDAO = new LocationDAO(
                locationDTO.getName(),
                locationDTO.getCountry().getName(),
                locationDTO.getCoordinates().getLatitude(),
                locationDTO.getCoordinates().getLongitude()
        );

        locationRepo.save(locationDAO);

        return locationRepo.findById(1);

        //return locationDTO;
    }
}
