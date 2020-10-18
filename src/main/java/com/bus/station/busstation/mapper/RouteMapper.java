package com.bus.station.busstation.mapper;

import com.bus.station.busstation.model.Route;
import com.bus.station.busstation.model.dto.RouteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RouteMapper {

    RouteMapper INSTANCE = Mappers.getMapper(RouteMapper.class);

    RouteDTO routeDTO(Route route);

    Route route(RouteDTO routeDTO);
}
