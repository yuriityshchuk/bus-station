package com.bus.station.busstation.controller;

import com.bus.station.busstation.model.Driver;
import com.bus.station.busstation.model.Ticket;
import com.bus.station.busstation.repository.TicketRepository;
import com.bus.station.busstation.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketSerivce;

    public TicketController(TicketService ticketService) {
        this.ticketSerivce = ticketService;
    }

    @DeleteMapping("/{ticketId}")
    public ResponseEntity<?> deleteByTicketId(@PathVariable("ticketId") int ticketId) {
        ticketSerivce.deleteById(ticketId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{ticketId}")
    public ResponseEntity<?> updateTicket(@RequestBody Ticket ticket) {
        return ResponseEntity.status(HttpStatus.OK).body(ticketSerivce.update(ticket));
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveTicket(@RequestBody Ticket ticket) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ticketSerivce.save(ticket));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllTickets() {
        return ResponseEntity.status(HttpStatus.OK).body(ticketSerivce.getAll());
    }
    
}
