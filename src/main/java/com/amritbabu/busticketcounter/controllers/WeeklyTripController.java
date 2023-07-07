package com.amritbabu.busticketcounter.controllers;

import com.amritbabu.busticketcounter.dto.CreateWeekelyTripDto;
import com.amritbabu.busticketcounter.dto.SuccessResponse;
import com.amritbabu.busticketcounter.dto.UpdateWeeklyTripDto;
import com.amritbabu.busticketcounter.services.WeeklyTripService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController()
@RequestMapping("weekly-trip")
public class WeeklyTripController {

    private final WeeklyTripService weeklyTripService;

    public WeeklyTripController(WeeklyTripService weeklyTripService) {
        this.weeklyTripService = weeklyTripService;
    }

    @PostMapping("/create")
    public SuccessResponse create(@RequestBody() CreateWeekelyTripDto dto){
        return this.weeklyTripService.create(dto);
    }

    @PatchMapping("/update/{trip-id}")
    public SuccessResponse update(@PathVariable("trip-id") UUID tripId, @RequestBody()UpdateWeeklyTripDto dto){
        return this.weeklyTripService.update(tripId, dto);
    }

    @DeleteMapping("/delete/{trip-id}")
    public SuccessResponse delete(@PathVariable("trip-id") UUID tripId){
        return this.weeklyTripService.delete(tripId);
    }

}
