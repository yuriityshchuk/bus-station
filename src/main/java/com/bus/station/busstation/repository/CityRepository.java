package com.bus.station.busstation.repository;

import com.bus.station.busstation.model.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<City, Integer> {
}
