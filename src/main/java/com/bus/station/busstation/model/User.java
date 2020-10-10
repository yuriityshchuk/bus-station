package com.bus.station.busstation.model;

import com.bus.station.busstation.model.utility.BasePerson;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class User extends BasePerson {


    @NotNull
    private String username;

    @NotNull
    private String password;

    @Transient
    private String repeatedPassword;

    @NotNull
    @Column(name = "registration_date")
    private Date registrationDate;

    @NotNull
    private String email;

    @NotNull
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private List<Ticket> ticketList;
}
