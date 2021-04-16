package com.weather.api.repository;

import com.weather.api.entities.LocationDAO;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<LocationDAO, Long> {
    LocationDAO findById(long id);
}
