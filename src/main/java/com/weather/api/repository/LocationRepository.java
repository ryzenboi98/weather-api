package com.weather.api.repository;

import com.weather.api.entities.location.LocationDAO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LocationRepository extends CrudRepository<LocationDAO, Long> {
    LocationDAO findById(long id);

    List<LocationDAO> findByLocation(String location);
    List<LocationDAO> findByLocationAndCountry(String location, String country);
}
