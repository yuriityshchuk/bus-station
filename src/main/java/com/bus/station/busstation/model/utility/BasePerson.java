package com.bus.station.busstation.model.utility;

import com.bus.station.busstation.model.utility.enums.Gender;
import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public class BasePerson {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;


}
