package com.amritbabu.busticketcounter.services;

import com.amritbabu.busticketcounter.dao.DailyTripRepository;
import com.amritbabu.busticketcounter.dto.CreateDailyTripDto;
import com.amritbabu.busticketcounter.dto.SuccessResponse;
import com.amritbabu.busticketcounter.dto.UpdateDailyTripDto;
import com.amritbabu.busticketcounter.entities.DailyTrip;
import com.amritbabu.busticketcounter.helpers.DaoHelpers;

import java.util.Optional;
import java.util.UUID;

public class DailyTripService {

    private final DailyTripRepository dailyTripRepository;

    public DailyTripService(DailyTripRepository dailyTripRepository) {
        this.dailyTripRepository = dailyTripRepository;
    }

    public SuccessResponse create(CreateDailyTripDto dto){
        DailyTrip dailyTrip = new DailyTrip();
        dailyTrip.setRouteId(dto.getRouteId());
        dailyTrip.setTime(dto.getTime());
        this.dailyTripRepository.save(dailyTrip);
        return SuccessResponse.getInstance("successfully created");
    }

    public SuccessResponse updateTime(UUID tripId, UpdateDailyTripDto dto){
        DailyTrip dailyTrip = DaoHelpers
                .validateIdAndGetItem(this.dailyTripRepository,
                        tripId);

        dailyTrip.setTime(dto.getTime());
        this.dailyTripRepository.save(dailyTrip);
        return SuccessResponse.getInstance();
    }

    public SuccessResponse delete(UUID tripId){
      DaoHelpers.validateIdAndGetItem(this.dailyTripRepository,
              tripId);
        this.dailyTripRepository.deleteById(tripId);
        return SuccessResponse.getInstance();
    }

}
