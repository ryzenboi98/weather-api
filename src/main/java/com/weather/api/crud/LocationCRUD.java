package com.weather.api.crud;

import com.weather.api.entities.location.LocationDAO;
import com.weather.api.entities.location.LocationDTO;
import com.weather.api.exceptions.LocationNotProvidedException;
import com.weather.api.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LocationCRUD implements LocationCRUDActions{
    @Autowired
    LocationRepository locationRepo;

    @Override
    public LocationDAO createLocation(LocationDTO locationDTO) {

        LocationDAO locationDAO = new LocationDAO(
                locationDTO.getLocation(),
                locationDTO.getName(),
                locationDTO.getCountry().getName(),
                locationDTO.getCoordinates().getLatitude(),
                locationDTO.getCoordinates().getLongitude()
        );

        locationRepo.save(locationDAO);

        return locationDAO;
    }

    @Override
    public List<LocationDAO> findByName(String location) {
        String[] parts = location.split(",");

        return locationRepo.findByLocation(parts[0]);
    }

    @Override
    public List<LocationDAO> findByNameAndCountry(String location) {
        String[] parts;

        try {
            parts = location.split(",");
        } catch (NullPointerException e) {
            throw new LocationNotProvidedException();
        }

        if(parts.length == 1)
            return locationRepo.findByLocation(parts[0]);
        else
            return locationRepo.findByLocationAndCountry(parts[0], parts[1]);
    }
}
