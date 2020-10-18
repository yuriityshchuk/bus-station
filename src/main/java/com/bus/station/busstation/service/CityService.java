package com.bus.station.busstation.service;

import com.bus.station.busstation.model.City;
import com.bus.station.busstation.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public Iterable<City> getAll() {
        return cityRepository.findAll();
    }
}
