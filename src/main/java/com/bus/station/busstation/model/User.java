package com.bus.station.busstation.model;

import com.bus.station.busstation.model.utility.BasePerson;
import com.bus.station.busstation.model.utility.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class User extends BasePerson {


    private String username;

    private String password;

    @Transient
    private String repeatedPassword;

    @Column(name = "registration_date")
    private Date registrationDate;

    private String email;

    private String telephone;

    private boolean locked;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private List<Ticket> ticketList;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;
}
