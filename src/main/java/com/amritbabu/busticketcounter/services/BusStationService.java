package com.amritbabu.busticketcounter.services;

import com.amritbabu.busticketcounter.Utils.ModelFromDto;
import com.amritbabu.busticketcounter.dao.BusStationRepository;
import com.amritbabu.busticketcounter.dto.BusStationDto;
import com.amritbabu.busticketcounter.dto.BusStationUpdateDto;
import com.amritbabu.busticketcounter.dto.SuccessResponse;
import com.amritbabu.busticketcounter.entities.BusStation;
import com.amritbabu.busticketcounter.helpers.DaoHelpers;

import java.util.Optional;
import java.util.UUID;

public class BusStationService {
    private final BusStationRepository busStationRepository;

    public BusStationService(BusStationRepository busStationRepository) {
        this.busStationRepository = busStationRepository;
    }

    public SuccessResponse create(BusStationDto busStationDto){
        BusStation busStation = ModelFromDto.createBusStation(busStationDto);
        this.busStationRepository.save(busStation);
        return SuccessResponse.getInstance();
    }

    public SuccessResponse update(UUID stationId, BusStationUpdateDto busStationUpdateDto){
        BusStation busStation = DaoHelpers.validateIdAndGetItem(this.busStationRepository, stationId);
        BusStation busStation1 = ModelFromDto.updateBusStation(busStation,busStationUpdateDto);
        this.busStationRepository.save(busStation1);
        return SuccessResponse.getInstance();
    }

    public SuccessResponse delete(UUID stationId){
        this.busStationRepository.deleteById(stationId);
        return SuccessResponse.getInstance();
    }

}
