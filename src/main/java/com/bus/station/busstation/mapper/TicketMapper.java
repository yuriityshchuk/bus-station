package com.bus.station.busstation.mapper;

import com.bus.station.busstation.model.Ticket;
import com.bus.station.busstation.model.dto.TicketDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    @Mappings({
            @Mapping(target = "clientEmail", source = "email"),
            @Mapping(source = "username", target = "user.username")
    })
    Ticket ticket(TicketDTO ticketDTO);
}
