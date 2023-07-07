package com.amritbabu.busticketcounter.services;

import com.amritbabu.busticketcounter.dao.*;
import com.amritbabu.busticketcounter.dto.CreateTicketDto;
import com.amritbabu.busticketcounter.dto.SuccessResponse;
import com.amritbabu.busticketcounter.entities.*;
import com.amritbabu.busticketcounter.helpers.DaoHelpers;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

public class TicketService {
    private final TicketRepository ticketRepository;
    private final BusReservationRepository busReservationRepository;
    private final DailyTripRepository dailyTripRepository;
    private final WeeklyTripRepository weeklyTripRepository;
    private  final RouteRepository routeRepository;
    private final BusStationRepository busStationRepository;

    public TicketService(TicketRepository ticketRepository, BusReservationRepository busReservationRepository, DailyTripRepository dailyTripRepository, WeeklyTripRepository weeklyTripRepository, RouteRepository routeRepository, BusStationRepository busStationRepository) {
        this.ticketRepository = ticketRepository;
        this.busReservationRepository = busReservationRepository;
        this.dailyTripRepository = dailyTripRepository;
        this.weeklyTripRepository = weeklyTripRepository;
        this.routeRepository = routeRepository;
        this.busStationRepository = busStationRepository;
    }

    public Ticket create(CreateTicketDto dto){
        BusReservation busReservation = DaoHelpers.validateIdAndGetItem(this.busReservationRepository,
                dto.getBusReservationId());
        Route route;
        if(busReservation.isWeeklyTrip()){
            WeeklyTrip weeklyTrip = DaoHelpers.validateIdAndGetItem(this.weeklyTripRepository,
                    busReservation.getTripId());
            route = DaoHelpers.validateIdAndGetItem(this.routeRepository, weeklyTrip.getRouteId());
        }else{
            DailyTrip dailyTrip = DaoHelpers.validateIdAndGetItem(this.dailyTripRepository,
                    busReservation.getTripId());
            route = DaoHelpers.validateIdAndGetItem(this.routeRepository, dailyTrip.getRouteId());
        }

        boolean areBusStationsOutsideRoute = ! (doesRouteContainsBusStation(dto.getDepartureStationID(),route) &&
                doesRouteContainsBusStation(dto.getDestinationStationId(),route));
        if(areBusStationsOutsideRoute){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "bus station doesn't lie in route");
        }
        BusStation departureStation = DaoHelpers.validateIdAndGetItem(this.busStationRepository,
                dto.getDepartureStationID());
        BusStation destinationStation = DaoHelpers.validateIdAndGetItem(this.busStationRepository,
                dto.getDepartureStationID());
        Ticket ticket = new Ticket();
        ticket.setPassengerName(dto.getPassengerName());
        ticket.setBusReservation(busReservation);
        ticket.setDepartureStation(departureStation);
        ticket.setDestinationStation(destinationStation);;
        ticket.setSeatCode(dto.getSeatCode());
        List<String> reservedSeats =    busReservation.getReservedSeatList();
               reservedSeats.add(dto.getSeatCode());
        busReservation.setReservedSeatList(reservedSeats);
        Ticket ticket1 = this.ticketRepository.save(ticket);
        this.busReservationRepository.save(busReservation);
        return ticket1;

    }

    public boolean doesRouteContainsBusStation(UUID stationId, Route route){
        final boolean[] result = {route.getOriginationStation().getId() == stationId};
        result[0] = result[0] || route.getEndingStation().getId()==stationId;
        route.getPassingBusStations().forEach(busStation -> {
            result[0] = result[0] || busStation.getId() == stationId;
        });
        return result[0];
    }

}
