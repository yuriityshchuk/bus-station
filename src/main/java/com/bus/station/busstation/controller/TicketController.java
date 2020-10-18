package com.bus.station.busstation.controller;

import com.bus.station.busstation.model.Ticket;
import com.bus.station.busstation.model.dto.TicketDTO;
import com.bus.station.busstation.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tickets")
@CrossOrigin("*")

public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @DeleteMapping("/{ticketId}")
    public ResponseEntity<?> deleteByTicketId(@PathVariable("ticketId") int ticketId) {
        ticketService.deleteById(ticketId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{ticketId}")
    public ResponseEntity<?> updateTicket(@RequestBody Ticket ticket) {
        return ResponseEntity.status(HttpStatus.OK).body(ticketService.update(ticket));
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveTicket(@RequestBody Ticket ticket) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ticketService.save(ticket));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllTickets() {
        return ResponseEntity.status(HttpStatus.OK).body(ticketService.getAll());
    }

    @PostMapping("/buy/{numberOfPassengers}")
    public ResponseEntity<?> buyTicket(@RequestBody TicketDTO ticketDTO,
                                       @PathVariable("numberOfPassengers") int numberOfPassengers) {
        ticketService.buy(ticketDTO, numberOfPassengers);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
