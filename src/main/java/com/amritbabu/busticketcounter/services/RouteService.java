package com.amritbabu.busticketcounter.services;

import com.amritbabu.busticketcounter.Utils.ModelFromDto;
import com.amritbabu.busticketcounter.dao.RouteRepository;
import com.amritbabu.busticketcounter.dto.CreateRouteDto;
import com.amritbabu.busticketcounter.dto.SuccessResponse;
import com.amritbabu.busticketcounter.dto.UpdateRouteDto;
import com.amritbabu.busticketcounter.entities.Route;
import com.amritbabu.busticketcounter.helpers.DaoHelpers;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;

public class RouteService {
private final RouteRepository routeRepository;


    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public SuccessResponse create(CreateRouteDto dto){
        Route route = ModelFromDto.createRoute(dto);
        this.routeRepository.save(route);
        return SuccessResponse.getInstance("successfully created");
    }

    public SuccessResponse update(UUID routeId, UpdateRouteDto dto){
        Route route = DaoHelpers.validateIdAndGetItem(this.routeRepository,routeId);
        Route route1 = ModelFromDto.updateRoute(route,dto);
        this.routeRepository.save(route1);
        return SuccessResponse.getInstance();
    }

    //public  SuccessResponse delete(UUID routeId)
}
