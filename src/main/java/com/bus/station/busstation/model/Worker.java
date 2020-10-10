package com.bus.station.busstation.model;

import com.bus.station.busstation.model.utility.BasePerson;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
public class Worker extends BasePerson {


    @Column(name = "birth_date")
    @NotNull
    private Date birthDate;

    private String telephone;

    private String city;

    private String street;

    @Column(name = "number_of_building")
    private String numberOfBuilding;

    @NotEmpty
    private String role;

    @Column(name = "date_of_employed")
    @NotNull
    private Date dateOfEmployed;
}
