package com.bus.station.busstation.repository;

import com.bus.station.busstation.model.Route;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends CrudRepository<Route, Integer> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM ROUTE WHERE ROUTE.DEPARTURE_PLACE_ID=? AND ROUTE.ARRIVAL_PLACE_ID=?")
    Iterable<Route> getAllByDepartureIdAndArrivalId(int departureId, int arrivalId);
}
