package com.weather.api.crud;

import com.weather.api.entities.LocationDAO;
import com.weather.api.entities.LocationDTO;
import com.weather.api.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LocationCRUD implements LocationCRUDActions{
    @Autowired
    LocationRepository locationRepo;

    public LocationCRUD() {
    }

    @Override
    public LocationDAO createLocation(LocationDTO locationDTO) {

        LocationDAO locationDAO = new LocationDAO(
                locationDTO.getName(),
                locationDTO.getCountry().getName(),
                locationDTO.getCoordinates().getLatitude(),
                locationDTO.getCoordinates().getLongitude()
        );

        locationRepo.save(locationDAO);

        return locationDAO;
    }

    @Override
    public List<LocationDAO> findByNameAndCountry(String name, String country) {
        return locationRepo.findByNameAndCountry(name, country);
    }
}
