package com.bus.station.busstation.model.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class RouteDTO {

    private int departurePlaceId;

    private int arrivalPlaceId;

    private Date departureDate;

    private int numberOfPassengers;
}
