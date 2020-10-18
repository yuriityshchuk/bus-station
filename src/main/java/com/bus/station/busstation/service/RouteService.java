package com.bus.station.busstation.service;

import com.bus.station.busstation.exception.DataNotFoundException;
import com.bus.station.busstation.model.Route;
import com.bus.station.busstation.model.dto.RouteDTO;
import com.bus.station.busstation.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteService {

    private final RouteRepository routeRepository;

    @Autowired
    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public Route save(Route route) {
        return routeRepository.save(route);
    }

    public Iterable<Route> getAll() {
        return routeRepository.findAll();
    }

    public Route getById(int id) {
        return routeRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Route with id: " + id + " not found"));
    }

    public void deleteById(int id) {
        routeRepository.deleteById(id);
    }

    public Route update(Route route) {
        return routeRepository.save(route);
    }

    public Iterable<Route> getRoutesByDepartureIdAndArrivalId(int departureId, int arrivalId) {
        return routeRepository.getAllByDepartureIdAndArrivalId(departureId, arrivalId);
    }

    public Iterable<Route> getAllByDateArrivalDeparturePlacesAndPassengers(RouteDTO routeDTO) {
        return routeRepository.
                getAllByDateArrivalDeparturePlacesAndPassengers(routeDTO.getArrivalPlaceId(),
                        routeDTO.getDeparturePlaceId(),
                        routeDTO.getDepartureDate(),
                        routeDTO.getNumberOfPassengers());
    }
}
