package com.amritbabu.busticketcounter.controllers;


import com.amritbabu.busticketcounter.dto.BusStationDto;
import com.amritbabu.busticketcounter.dto.BusStationUpdateDto;
import com.amritbabu.busticketcounter.dto.SuccessResponse;
import com.amritbabu.busticketcounter.services.BusStationService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController()
@RequestMapping("bus-station")
public class BusStationController {

    private final BusStationService busStationService;

    public BusStationController(BusStationService busStationService) {
        this.busStationService = busStationService;
    }

    @PostMapping("/create")
    public SuccessResponse create(@RequestBody()BusStationDto dto){
        return this.busStationService.create(dto);
    }

    @PatchMapping("/update/{bus-station-id")
    public SuccessResponse update(@PathVariable("bus-station-id")UUID busStationId,
                                  BusStationUpdateDto dto){
        return this.busStationService.update(busStationId,dto);
    }

    @DeleteMapping("/delete/{bus-station-id}")
    public SuccessResponse delete(@PathVariable("bus-station-id") UUID id){
        return this.busStationService.delete(id);
    }
}
