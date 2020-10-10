package com.bus.station.busstation.model;

import com.bus.station.busstation.model.utility.BasePerson;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Driver extends BasePerson {

    @NotEmpty
    @Column(name = "driver_license", unique = true)
    private String driverLicense;

    @ManyToMany
    @JoinTable(name = "DRIVER_BUS",
            joinColumns = {@JoinColumn(name = "driver_id")},
            inverseJoinColumns = {@JoinColumn(name = "bus_id")})
    @NotNull
    private List<Bus> busList;
}
