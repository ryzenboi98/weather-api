package com.weather.api.crud;

import com.weather.api.entities.location.LocationDAO;
import com.weather.api.entities.location.LocationDTO;

import java.util.List;

public interface LocationCRUDActions {
    LocationDAO createLocation(LocationDTO locationDTO);
    List<LocationDAO> findByName(String location);
    List<LocationDAO> findByNameAndCountry(String location);
}
