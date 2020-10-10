package com.bus.station.busstation.service;

import com.bus.station.busstation.exception.DataNotFoundException;
import com.bus.station.busstation.model.Driver;
import com.bus.station.busstation.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    private final DriverRepository driverRepository;

    @Autowired
    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Driver save(Driver driver) {
        return driverRepository.save(driver);
    }

    public Iterable<Driver> getAll() {
        return driverRepository.findAll();
    }

    public Driver getById(int id) {
        return driverRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Driver with id: " + id + " not found"));
    }

    public void deleteById(int id) {
        driverRepository.deleteById(id);
    }

    public Driver update(Driver driver) {
        return driverRepository.save(driver);
    }

    public Driver getByDriverLicense(String driverLicense) {
        return driverRepository.getByDriverLicense(driverLicense)
                .orElseThrow(() -> new DataNotFoundException("Driver with driver licence: " + driverLicense
                        + " not found"));
    }
}
