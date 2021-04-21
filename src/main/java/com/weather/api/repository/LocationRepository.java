package com.weather.api.repository;

import com.weather.api.entities.LocationDAO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LocationRepository extends CrudRepository<LocationDAO, Long> {
    LocationDAO findById(long id);

    List<LocationDAO> findByName(String name);
    List<LocationDAO> findByNameAndCountry(String name, String country);
}
