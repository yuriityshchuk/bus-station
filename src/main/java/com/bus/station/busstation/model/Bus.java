package com.bus.station.busstation.model;

import com.bus.station.busstation.model.utility.enums.BusClass;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    private String number;

    @NotEmpty
    private String name;

    @Max(100)
    @Min(0)
    @NotNull
    @Column(name = "max_number_of_passengers")
    private int maxNumberOfPassengers;

    @NotNull
    @Column(name = "create_date")
    private Date createDate;

    @NotEmpty
    private String VIN;

    @Column(name = "currently_used")
    private boolean currentlyUsed;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "bus_class")
    private BusClass busClass;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "bus_id")
    @JsonIgnore
    private List<Route> routeList;
}
