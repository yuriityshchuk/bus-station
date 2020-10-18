package com.bus.station.busstation.controller;

import com.bus.station.busstation.model.Driver;
import com.bus.station.busstation.service.DriverService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/drivers")
@CrossOrigin("*")

public class DriverController {

    public final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @DeleteMapping("/{driverId}")
    public ResponseEntity<?> deleteByDriverId(@PathVariable("driverId") int driverId) {
        driverService.deleteById(driverId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{driverId}")
    public ResponseEntity<?> updateDriver(@RequestBody Driver driver) {
        return ResponseEntity.status(HttpStatus.OK).body(driverService.update(driver));
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveDriver(@RequestBody Driver driver) {
        return ResponseEntity.status(HttpStatus.CREATED).body(driverService.save(driver));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllDrivers() {
        return ResponseEntity.status(HttpStatus.OK).body(driverService.getAll());
    }

    @GetMapping("/driver-license")
    public ResponseEntity<?> getDriverByDriverLicence(@RequestParam("driver-license") String driverLicence) {
        return ResponseEntity.status(HttpStatus.OK).body(driverService.getByDriverLicense(driverLicence));
    }
}
