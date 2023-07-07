package com.amritbabu.busticketcounter.services;

import com.amritbabu.busticketcounter.Utils.ModelFromDto;
import com.amritbabu.busticketcounter.dao.BusRepository;
import com.amritbabu.busticketcounter.dto.CreateBusDto;
import com.amritbabu.busticketcounter.dto.SuccessResponse;
import com.amritbabu.busticketcounter.entities.Bus;
import com.amritbabu.busticketcounter.helpers.DaoHelpers;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

public class BusService {

    private final BusRepository busRepository;

    public BusService(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    public SuccessResponse createBuses(List<CreateBusDto> createBusDtoList){
        List<Bus> busList = ModelFromDto.createFromCreateBusDto(createBusDtoList);
        List<Bus> busCreated = this.busRepository.saveAll(busList);
        return SuccessResponse.getInstance("successfully created");
    }

    public SuccessResponse updateBus(String busNumber, List<String> seatCodes){
        Bus bus = DaoHelpers.validateIdAndGetItem(this.busRepository,busNumber);
        bus.setSeatCodes(seatCodes);
        this.busRepository.save(bus);
        return SuccessResponse.getInstance();
    }

    public SuccessResponse deleteBus(String busNumber){
        DaoHelpers.validateIdAndDeleteItem(this.busRepository, busNumber);
        //remove bus from DailyTrip and WeekelyTrip on the scheduled service method that creates reservation for trips
        return SuccessResponse.getInstance();
    }
}
