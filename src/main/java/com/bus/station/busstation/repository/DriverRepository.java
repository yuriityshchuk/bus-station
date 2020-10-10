package com.bus.station.busstation.repository;

import com.bus.station.busstation.model.Driver;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriverRepository extends CrudRepository<Driver, Integer> {

    Optional<Driver> getByDriverLicense(String driverLicense);
}
