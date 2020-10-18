package com.bus.station.busstation.model;

import com.bus.station.busstation.model.utility.enums.TicketStatus;
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

    @Column(name = "client_email")
    private String clientEmail;

    @NotNull
    @Column(name = "buy_time")
    private Date buyTime;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonIgnore
    private User user;

    @Enumerated(EnumType.STRING)
    private TicketStatus status;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Route route;


}
