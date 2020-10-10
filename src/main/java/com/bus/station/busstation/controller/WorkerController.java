package com.bus.station.busstation.controller;

import com.bus.station.busstation.model.Worker;
import com.bus.station.busstation.service.WorkerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.FOUND;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/workers")
public class WorkerController {

    private final WorkerService workerService;

    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id) {
        return ResponseEntity.status(FOUND).body(workerService.getById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.status(FOUND).body(workerService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") int id) {
        workerService.deleteById(id);

        return new ResponseEntity<>(OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Worker worker) {
        return ResponseEntity.status(OK).body(workerService.save(worker));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Worker worker) {
        return ResponseEntity.status(OK).body(workerService.update(worker));
    }
}
