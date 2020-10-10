package com.bus.station.busstation.service;

import com.bus.station.busstation.exception.DataNotFoundException;
import com.bus.station.busstation.model.Bus;
import com.bus.station.busstation.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusService {

    private final BusRepository busRepository;

    @Autowired
    public BusService(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    public Bus save(Bus bus) {
        return busRepository.save(bus);
    }

    public Iterable<Bus> getAll() {
        return busRepository.findAll();
    }

    public Bus getById(int id) {
        return busRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Bus with id: " + id + " not found"));
    }

    public void deleteById(int id) {
        busRepository.deleteById(id);
    }

    public Bus update(Bus bus) {
        return busRepository.save(bus);
    }

    public Iterable<Bus> getAllByCurrentlyUsed(boolean currentlyUsed) {
        return busRepository.getAllByCurrentlyUsed(currentlyUsed);
    }
}
