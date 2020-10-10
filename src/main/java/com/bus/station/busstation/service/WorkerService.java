package com.bus.station.busstation.service;

import com.bus.station.busstation.exception.DataNotFoundException;
import com.bus.station.busstation.model.Worker;
import com.bus.station.busstation.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkerService {

    private final WorkerRepository workerRepository;

    @Autowired
    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public Worker save(Worker worker) {
        return workerRepository.save(worker);
    }

    public Iterable<Worker> getAll() {
        return workerRepository.findAll();
    }

    public Worker getById(int id) {
        return workerRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Worker with id: " + id + " not found"));
    }

    public void deleteById(int id) {
        workerRepository.deleteById(id);
    }

    public Worker update(Worker worker) {
        return workerRepository.save(worker);
    }


}
