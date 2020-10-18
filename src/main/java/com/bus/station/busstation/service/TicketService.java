package com.bus.station.busstation.service;

import com.bus.station.busstation.exception.DataNotFoundException;
import com.bus.station.busstation.mapper.TicketMapper;
import com.bus.station.busstation.model.Route;
import com.bus.station.busstation.model.Ticket;
import com.bus.station.busstation.model.User;
import com.bus.station.busstation.model.dto.TicketDTO;
import com.bus.station.busstation.model.utility.enums.TicketStatus;
import com.bus.station.busstation.repository.TicketRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
@Log4j2
public class TicketService {

    private final TicketRepository ticketRepository;

    private final TicketMapper ticketMapper;

    private final UserService userService;

    private final RouteService routeService;

    @Autowired
    public TicketService(TicketRepository ticketRepository, TicketMapper ticketMapper,
                         UserService userService, RouteService routeService) {
        this.ticketRepository = ticketRepository;
        this.ticketMapper = ticketMapper;
        this.userService = userService;
        this.routeService = routeService;
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

    public void buy(TicketDTO ticketDTO, int numberOfPassengers) {

        int currentNumberOfPassengers = ticketDTO.getRoute().getNumberOfPassengers();
        User user = userService.findByUsername(ticketDTO.getUsername());
        Route route = routeService.getById(ticketDTO.getRoute().getId());
        route.setNumberOfPassengers(currentNumberOfPassengers - numberOfPassengers);
        for (int i = 0; i < numberOfPassengers; i++) {
            Ticket ticket = ticketMapper.ticket(ticketDTO);
            ticket.setBuyTime(new Date());
            ticket.getRoute().setNumberOfPassengers(currentNumberOfPassengers - 1);
            ticket.setStatus(TicketStatus.ACTIVE);
            ticket.setUser(user);
            save(ticket);
        }

    }
}
