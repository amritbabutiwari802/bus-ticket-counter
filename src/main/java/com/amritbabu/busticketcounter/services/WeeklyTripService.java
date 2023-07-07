package com.amritbabu.busticketcounter.services;

import com.amritbabu.busticketcounter.dao.WeeklyTripRepository;
import com.amritbabu.busticketcounter.dto.CreateWeekelyTripDto;
import com.amritbabu.busticketcounter.dto.SuccessResponse;
import com.amritbabu.busticketcounter.dto.UpdateWeeklyTripDto;
import com.amritbabu.busticketcounter.entities.WeeklyTrip;
import com.amritbabu.busticketcounter.helpers.DaoHelpers;

import java.sql.Time;
import java.util.UUID;

public class WeeklyTripService {

    private final WeeklyTripRepository weeklyTripRepository;

    public WeeklyTripService(WeeklyTripRepository weeklyTripRepository) {
        this.weeklyTripRepository = weeklyTripRepository;
    }

    public SuccessResponse create(CreateWeekelyTripDto dto){
        WeeklyTrip weeklyTrip = new WeeklyTrip();
        weeklyTrip.setDay(dto.getDay());
        weeklyTrip.setTime(dto.getTime());
        weeklyTrip.setRouteId(dto.getRouteId());
        this.weeklyTripRepository.save(weeklyTrip);
        return SuccessResponse.getInstance();
    }

    public SuccessResponse update(UUID id, UpdateWeeklyTripDto dto){
        WeeklyTrip weeklyTrip = DaoHelpers.validateIdAndGetItem(this.weeklyTripRepository,

                id);
        int day = dto.getDay() == null? weeklyTrip.getDay(): dto.getDay();
        Time time = dto.getTime() == null? weeklyTrip.getTime(): dto.getTime();
        weeklyTrip.setDay(day);
        weeklyTrip.setTime(time);
        this.weeklyTripRepository.save(weeklyTrip);
        return SuccessResponse.getInstance();
    }

    public SuccessResponse delete(UUID id){
        DaoHelpers.validateIdAndDeleteItem(this.weeklyTripRepository,id);
        return SuccessResponse.getInstance();
    }

}
