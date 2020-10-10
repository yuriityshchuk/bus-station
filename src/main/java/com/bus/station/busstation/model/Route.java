package com.bus.station.busstation.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "arrival_place_id")
    @NotNull
    private City arrivalPlace;

    @ManyToOne
    @JoinColumn(name = "departure_place_id")
    @NotNull
    private City departurePlace;

    @NotNull
    @Column(name = "arrival_date")
    private Date arrivalDate;

    @NotNull
    @Column(name = "departure_date")
    private Date departureDate;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "route_id")
    private List<Ticket> ticketList;
}
