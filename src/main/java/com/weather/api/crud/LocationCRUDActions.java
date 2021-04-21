package com.weather.api.crud;

import com.weather.api.entities.LocationDAO;
import com.weather.api.entities.LocationDTO;

import java.util.List;

public interface LocationCRUDActions {
    LocationDAO createLocation(LocationDTO locationDTO);
    List<LocationDAO> findByNameAndCountry(String location);
}
