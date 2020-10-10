package com.bus.station.busstation.service;

import com.bus.station.busstation.exception.DataNotFoundException;
import com.bus.station.busstation.model.Ticket;
import com.bus.station.busstation.model.utility.TicketStatus;
import com.bus.station.busstation.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket save(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public Iterable<Ticket> getAll() {
        return ticketRepository.findAll();
    }

    public Ticket getById(int id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Ticket with id: " + id + " not found"));
    }

    public void deleteById(int id) {
        Ticket ticket = getById(id);

        ticket.setStatus(TicketStatus.INACTIVE);

        update(ticket);
    }

    public Ticket update(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public Iterable<Ticket> getAllTicketsByRouteId(int routeId) {
        return ticketRepository.getAllByRouteId(routeId);
    }

    public Iterable<Ticket> getAllTicketsByUserId(int userId) {
        return ticketRepository.getAllByUserId(userId);
    }

}
