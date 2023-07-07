package com.amritbabu.busticketcounter.controllers;

import com.amritbabu.busticketcounter.dto.CreateDailyTripDto;
import com.amritbabu.busticketcounter.dto.SuccessResponse;
import com.amritbabu.busticketcounter.dto.UpdateDailyTripDto;
import com.amritbabu.busticketcounter.services.DailyTripService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController()
@RequestMapping("/daily-trip")
public class DailyTripController {

    private final DailyTripService dailyTripService;

    public DailyTripController(DailyTripService dailyTripService) {
        this.dailyTripService = dailyTripService;
    }

    @PostMapping("/create")
    public SuccessResponse create(@RequestBody()CreateDailyTripDto dto){
        return this.dailyTripService.create(dto);
    }

    @PatchMapping("/update/{trip-id}")
    public SuccessResponse update(@PathVariable("trip-id")UUID tripId, UpdateDailyTripDto dto){
        return this.dailyTripService.updateTime(tripId, dto);
    }

    @DeleteMapping("/delete/{trip-id}")
    public SuccessResponse delete(@PathVariable("trip-id") UUID tripId){
        return  this.dailyTripService.delete(tripId);
    }

}
