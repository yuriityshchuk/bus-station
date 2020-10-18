package com.bus.station.busstation.model.dto;

import com.bus.station.busstation.model.Route;
import lombok.Data;

@Data
public class TicketDTO {

    private Route route;

    private String username;

    private String email;
}
