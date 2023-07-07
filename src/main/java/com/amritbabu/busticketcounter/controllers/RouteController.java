package com.amritbabu.busticketcounter.controllers;

import com.amritbabu.busticketcounter.dto.CreateRouteDto;
import com.amritbabu.busticketcounter.dto.SuccessResponse;
import com.amritbabu.busticketcounter.dto.UpdateRouteDto;
import com.amritbabu.busticketcounter.services.RouteService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController()
@RequestMapping("route")
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    public SuccessResponse create(@RequestBody()CreateRouteDto dto){
        return this.routeService.create(dto);
    }

    public SuccessResponse update(@PathVariable("route-id")UUID routeId, UpdateRouteDto dto){
        return this.routeService.update(routeId,dto);
    }

}
