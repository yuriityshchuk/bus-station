package com.bus.station.busstation.repository;

import com.bus.station.busstation.model.Bus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRepository extends CrudRepository<Bus, Integer> {

    Iterable<Bus> getAllByCurrentlyUsed(boolean currentlyUsed);
}
