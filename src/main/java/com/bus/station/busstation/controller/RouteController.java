package com.bus.station.busstation.controller;

import com.bus.station.busstation.model.Route;
import com.bus.station.busstation.service.RouteService;
import com.bus.station.busstation.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/routes")
public class RouteController {

    private final RouteService routeService;

    private final TicketService ticketService;

    public RouteController(RouteService routeService, TicketService ticketService) {
        this.routeService = routeService;
        this.ticketService = ticketService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(routeService.getAll());
    }

    @GetMapping("/{routeId}/bought-tickets")
    public ResponseEntity<?> getAllBoughtTicketsForRoute(@PathVariable("routeId") int routeId) {
        return ResponseEntity.status(HttpStatus.OK).body(ticketService.getAllTicketsByRouteId(routeId));
    }

    @GetMapping("/{departureId}/{arrivalId}")
    public ResponseEntity<?> getByDepartureIdAndArrivalId(@PathVariable("departureId") int departureId,
                                                          @PathVariable("arrivalId") int arrivalId) {
        return ResponseEntity.ok(routeService.getRoutesByDepartureIdAndArrivalId(departureId, arrivalId));
    }

    @DeleteMapping("/{routeId}")
    public ResponseEntity<?> deleteByRouteId(@PathVariable("routeId") int routeId) {
        routeService.deleteById(routeId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{routeId}")
    public ResponseEntity<?> updateRoute(@RequestBody Route route) {
        return ResponseEntity.status(HttpStatus.OK).body(routeService.update(route));
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveRoute(@RequestBody Route route) {
        return ResponseEntity.status(HttpStatus.CREATED).body(routeService.save(route));
    }
}
