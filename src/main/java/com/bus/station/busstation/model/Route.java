package com.bus.station.busstation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Data
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "arrival_place_id")
    private City arrivalPlace;

    @ManyToOne
    @JoinColumn(name = "departure_place_id")
    private City departurePlace;

    @Column(name = "arrival_date")
    private Date arrivalDate;

    @Column(name = "departure_date")
    private Date departureDate;

    @Column(name = "number_of_passengers")
    private int numberOfPassengers;

    @OneToMany(cascade = CascadeType.MERGE, orphanRemoval = true)
    @JoinColumn(name = "route_id")
    @JsonIgnore
    private List<Ticket> ticketList;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Bus bus;
}
