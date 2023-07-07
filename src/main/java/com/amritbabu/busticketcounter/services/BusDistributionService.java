package com.amritbabu.busticketcounter.services;

import com.amritbabu.busticketcounter.dao.BusDistributionRepository;
import com.amritbabu.busticketcounter.dao.BusRepository;
import com.amritbabu.busticketcounter.dao.DailyTripRepository;
import com.amritbabu.busticketcounter.dao.WeeklyTripRepository;
import com.amritbabu.busticketcounter.dto.AssignBusToTripDto;
import com.amritbabu.busticketcounter.dto.SuccessResponse;
import com.amritbabu.busticketcounter.dto.UnassignBusToTripDto;
import com.amritbabu.busticketcounter.entities.BusDistribution;
import com.amritbabu.busticketcounter.helpers.DaoHelpers;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BusDistributionService {
    private final BusRepository busRepository;
    private final BusDistributionRepository busDistributionRepository;
    private final WeeklyTripRepository weeklyTripRepository;
    private final DailyTripRepository dailyTripRepository;

    public BusDistributionService(
            BusRepository busRepository,
            BusDistributionRepository busDistributionRepository,
            WeeklyTripRepository weeklyTripRepository,
            DailyTripRepository dailyTripRepository
    ) {
        this.busRepository = busRepository;
        this.busDistributionRepository = busDistributionRepository;
        this.weeklyTripRepository = weeklyTripRepository;
        this.dailyTripRepository = dailyTripRepository;
    }

    public SuccessResponse assignBusToTrip(AssignBusToTripDto dto) {
        BusDistribution busDistribution = new BusDistribution();
        DaoHelpers.validatePrimaryKey(busRepository,
                dto.getBusNumber(),
                "no such bus exists");
        if (dto.isTripWeekely()) {
            DaoHelpers.validatePrimaryKey(weeklyTripRepository,
                    dto.getTripId(),
                    "no such trip exists");
            busDistribution.setWeeklyTrip(true);
        } else {
            DaoHelpers.validatePrimaryKey(
                    dailyTripRepository,
                    dto.getTripId(),
                    "no such trip exists"
            );
            busDistribution.setWeeklyTrip(false);
        }

        busDistribution.setBusNumber(dto.getBusNumber());
        busDistribution.setTripWeekely(dto.isTripWeekely());
        busDistribution.setTripId(dto.getTripId());
        this.busDistributionRepository.save(busDistribution);
        return SuccessResponse.getInstance("successfully assigned");

    }

    public SuccessResponse unassignBusToTrip(String busNumber, UnassignBusToTripDto dto) throws InterruptedException {
        List<BusDistribution> busDistributions = this.busDistributionRepository.
                findByBusNumberAndTripId(busNumber, dto.getTripId());
        this.busDistributionRepository.deleteAll(busDistributions);
        return SuccessResponse.getInstance();
    }
}
