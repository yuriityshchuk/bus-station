package com.bus.station.busstation.model;

import com.bus.station.busstation.model.utility.TicketStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "buy_time")
    private Date buyTime;

    @ManyToOne
    @NotNull
    @JsonIgnore
    private User user;

    @Enumerated(EnumType.STRING)
    @NotNull
    private TicketStatus status;

    @ManyToOne
    @NotNull
    @JsonIgnore
    private Bus bus;

    @ManyToOne
    @NotNull
    @JsonIgnore
    private Route route;
}
