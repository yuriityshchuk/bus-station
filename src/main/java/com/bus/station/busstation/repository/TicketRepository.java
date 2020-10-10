package com.bus.station.busstation.repository;

import com.bus.station.busstation.model.Ticket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Integer> {


    @Query(nativeQuery = true, value = "SELECT * FROM TICKET WHERE TICKET.ROUTE_ID=?")
    Iterable<Ticket> getAllByRouteId(int routeId);

    @Query(nativeQuery = true, value = "SELECT * FROM TICKET WHERE TICKET.USER_ID=?")
    Iterable<Ticket> getAllByUserId(int userId);
}
