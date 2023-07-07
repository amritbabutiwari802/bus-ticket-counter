package com.amritbabu.busticketcounter.services;

import com.amritbabu.busticketcounter.Utils.ModelFromDto;
import com.amritbabu.busticketcounter.dao.*;
import com.amritbabu.busticketcounter.entities.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.temporal.TemporalAdjusters.next;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class BusReservationService {

    private final DailyTripRepository dailyTripRepository;
    private final WeeklyTripRepository weeklyTripRepository;
    private final BusDistributionRepository busDistributionRepository;
    private final BusReservationRepository busReservationRepository;
    private final BusReservationHistoryRepository busReservationHistoryRepository;

    public BusReservationService(DailyTripRepository dailyTripRepository, WeeklyTripRepository weeklyTripRepository, BusDistributionRepository busDistributionRepository, BusReservationRepository busReservationRepository, BusReservationHistoryRepository busReservationHistoryRepository) {
        this.dailyTripRepository = dailyTripRepository;
        this.weeklyTripRepository = weeklyTripRepository;
        this.busDistributionRepository = busDistributionRepository;
        this.busReservationRepository = busReservationRepository;
        this.busReservationHistoryRepository = busReservationHistoryRepository;
    }

    @Scheduled(cron = "000*1?")
    public void addDailyReservation(){
        ExecutorService executors = Executors.newFixedThreadPool(16);
        List<DailyTrip> dailyTrips = this.dailyTripRepository.findAll();
        dailyTrips.forEach(dailyTrip -> {
            List<BusDistribution> busDistributions = this.
                    busDistributionRepository.findByTripId(dailyTrip.getID());
            List<Runnable> tasks = busDistributions.stream().map(busDistribution -> {
                Runnable task = ()->{
                    LocalDate reservationDate = LocalDate.now().plusDays(7);
                    BusReservation busReservation = new BusReservation();
                    busReservation.setBusNumber(busDistribution.getBusNumber());
                    busReservation.setTripId(dailyTrip.getID());
                    busReservation.setReservationDate(reservationDate);
                    busReservation.setDepatureTime(dailyTrip.getTime());
                    busReservation.setWeeklyTrip(false);
                    busReservation.setReservedSeatList(new ArrayList<>());
                    this.busReservationRepository.save(busReservation);

                };
                return task;
            }).toList();
         tasks.forEach(task ->{
             executors.submit(task);
         });

        });
    }

    @Scheduled(cron = "000?**")
    public void addWeeklyReservation(){
        ExecutorService executors = Executors.newFixedThreadPool(16);
        List<WeeklyTrip> weeklyTrips = this.weeklyTripRepository.findAll();
        weeklyTrips.forEach(weeklyTrip -> {
            List<BusDistribution> busDistributions = this.
                    busDistributionRepository.findByTripId(weeklyTrip.getId());
            List<Runnable> tasks = busDistributions.stream().map(busDistribution -> {
                Runnable task = ()->{
                    LocalDate reservationDate = LocalDate.now().with(next(SATURDAY)).
                            plusDays(weeklyTrip.getDay());
                    BusReservation busReservation = new BusReservation();
                    busReservation.setBusNumber(busDistribution.getBusNumber());
                    busReservation.setTripId(weeklyTrip.getId());
                    busReservation.setReservationDate(reservationDate);
                    busReservation.setDepatureTime(weeklyTrip.getTime());
                    busReservation.setWeeklyTrip(true);
                    busReservation.setReservedSeatList(new ArrayList<>());
                    this.busReservationRepository.save(busReservation);

                };
                return task;
            }).toList();
            tasks.forEach(task ->{
                executors.submit(task);
            });

        });
    }

    @Scheduled(cron = "004**?")
    public void removeOldBusReservations(){
        LocalDate date = LocalDate.now().minusDays(1);
            List<BusReservation> busReservations = this.busReservationRepository.
                    findByReservationDate(date);
            this.busReservationRepository.deleteAll(busReservations);;
        List<BusReservationHistory> busReservationHistories = busReservations.
                stream().map(busReservation ->
                        ModelFromDto.createBusReservationHistory(busReservation)
                ).toList();
        this.busReservationHistoryRepository.saveAll(busReservationHistories);
    }

}
