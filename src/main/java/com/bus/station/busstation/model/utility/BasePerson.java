package com.bus.station.busstation.model.utility;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@MappedSuperclass
public class BasePerson {


    @Id
    @GeneratedValue
    private int id;

    @Column(name = "first_name")
    @NotNull
    private String firstName;

    @Column(name = "last_name")
    @NotNull
    private String lastName;

    @NotEmpty
    @Enumerated(EnumType.STRING)
    private Gender gender;


}
