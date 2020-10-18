package com.bus.station.busstation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class BusStationApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusStationApplication.class, args);
    }

}
