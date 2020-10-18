package com.bus.station.busstation.controller;

import com.bus.station.busstation.model.Bus;
import com.bus.station.busstation.service.BusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/buses")
@CrossOrigin("*")

public class BusController {

    private final BusService busService;

    public BusController(BusService busService) {
        this.busService = busService;
    }

    @DeleteMapping("/{busId}")
    public ResponseEntity<?> deleteByRouteId(@PathVariable("busId") int busId) {
        busService.deleteById(busId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{busId}")
    public ResponseEntity<?> updateRoute(@RequestBody Bus bus) {
        return ResponseEntity.status(HttpStatus.OK).body(busService.update(bus));
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveRoute(@RequestBody Bus bus) {
        return ResponseEntity.status(HttpStatus.CREATED).body(busService.save(bus));
    }

    @GetMapping("/used")
    public ResponseEntity<?> getInfoAboutUsingOfBusses(@RequestParam("currentlyUsed") boolean currentlyUsed) {
        return ResponseEntity.status(HttpStatus.OK).body(busService.getAllByCurrentlyUsed(currentlyUsed));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllBusses() {
        return ResponseEntity.status(HttpStatus.OK).body(busService.getAll());
    }
}
