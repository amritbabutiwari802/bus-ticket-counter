package com.amritbabu.busticketcounter.controllers;

import com.amritbabu.busticketcounter.dao.BusDistributionRepository;
import com.amritbabu.busticketcounter.dto.AssignBusToTripDto;
import com.amritbabu.busticketcounter.dto.CreateBusDto;
import com.amritbabu.busticketcounter.dto.SuccessResponse;
import com.amritbabu.busticketcounter.dto.UnassignBusToTripDto;
import com.amritbabu.busticketcounter.services.BusDistributionService;
import com.amritbabu.busticketcounter.services.BusService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("bus")
public class BusController {

    private  final BusService busService;
    private final BusDistributionService busDistributionService;

    public BusController(BusService busService,  BusDistributionService busDistributionService) {
        this.busService = busService;
        this.busDistributionService = busDistributionService;
    }

    @PostMapping("/create")
    public SuccessResponse createBuses(@RequestBody() List<CreateBusDto> dto){
        return this.busService.createBuses(dto);
    }

    @PatchMapping("/update/{bus-number}")
    public SuccessResponse updateBus(@PathVariable("bus-number") String busNumber,
                                     @RequestBody() List<String> seatCodes  ){
        return this.busService.updateBus(busNumber, seatCodes);
    }

    @DeleteMapping("/delete/{bus-number}")
    public SuccessResponse deleteBus(@PathVariable("bus-number") String busNumber){
        return this.busService.deleteBus(busNumber);
    }

    public SuccessResponse assignBusToTrip(@RequestBody()AssignBusToTripDto dto){
        return this.busDistributionService.assignBusToTrip(dto);
    }

    public SuccessResponse unassignBusToTrip(@PathVariable("bus-number") String busNumber,
                      @RequestBody()UnassignBusToTripDto dto) throws InterruptedException {
        return this.busDistributionService.unassignBusToTrip(busNumber,dto);
    }

}
