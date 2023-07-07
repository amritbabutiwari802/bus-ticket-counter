package com.amritbabu.busticketcounter.Utils;

import com.amritbabu.busticketcounter.dto.*;
import com.amritbabu.busticketcounter.entities.*;

import java.util.ArrayList;
import java.util.List;

public class ModelFromDto {

    public static List<Bus> createFromCreateBusDto(List<CreateBusDto> createBusDto){
        if(createBusDto == null){
            return new ArrayList<>();
        }
        List<Bus> busList = createBusDto.stream().map(temp ->{
            Bus bus = new Bus();
            bus.setBusNumber(temp.getBusNumber());
            bus.setSeatCodes(temp.getSeatCodes());
            return bus;
        }).toList();
        return busList;
    }

    public static BusStation createBusStation(BusStationDto busStationCreationDto){
        BusStation busStation = new BusStation();
        busStation.setName(busStationCreationDto.getName());
        busStation.setLongitude(busStationCreationDto.getLongitude());
        busStation.setLatitude(busStationCreationDto.getLatitude());
        busStation.setProvince(busStationCreationDto.getProvince());
        busStation.setDistrict(busStationCreationDto.getDistrict());
        busStation.setMunicipality(busStationCreationDto.getMunicipality());
        return busStation;
    }

    public static BusStation updateBusStation(BusStation busStation, BusStationUpdateDto dto){
        String name = dto.getName() == null ? busStation.getName(): dto.getName();
        Double longitude = dto.getLongitude() == null ? busStation.getLongitude(): dto.getLongitude();
        Double latitude = dto.getLatitude() == null? busStation.getLatitude() : dto.getLatitude();
        String province = dto.getProvince() == null? busStation.getProvince(): dto.getProvince();
        String district = dto.getDistrict() == null? busStation.getDistrict(): dto.getDistrict();
        String municipality = dto.getMunicipality() == null? busStation.getMunicipality() : dto.getMunicipality();
        BusStation busStation1 = new BusStation();
        busStation1.setId(busStation.getId());
        busStation1.setName(name);
        busStation1.setLongitude(longitude);
        busStation1.setLatitude(latitude);
        busStation1.setDistrict(district);
        busStation1.setProvince(province);
        busStation1.setMunicipality(municipality);
        return busStation1;
    }

    public static Route createRoute(CreateRouteDto dto){
        Route route = new Route(
                dto.getName(),
                dto.getStartingProvince(),
                dto.getStartingDistrict(),
                dto.getEndingProvince(),
                dto.getEndingDistrict(),
                dto.getOriginationStation(),
                dto.getEndingStation(),
                dto.getPassingBusStations()
        );
        return route;
    }

    public static Route updateRoute(Route route, UpdateRouteDto dto){
        String name = dto.getName() ==null? route.getName(): dto.getName();
        String startingProvince = dto.getStartingProvince() == null? route.getStartingProvince(): dto.getStartingProvince();
        String startingDistrict = dto.getStartingDistrict() == null? route.getStartingDistrict(): dto.getStartingDistrict();
        BusStation originatingStation = dto.getOriginationStation() == null? route.getOriginationStation(): dto.getOriginationStation();
        String endingProvince = dto.getEndingProvince() == null? route.getEndingDistrict(): dto.getEndingDistrict();
        String endingDistrict = dto.getEndingDistrict() == null? route.getEndingDistrict(): dto.getEndingDistrict();
        BusStation endingStation = dto.getEndingStation() == null? route.getEndingStation(): dto.getEndingStation();
        List<BusStation> passingBusStations = dto.getPassingBusStations().size()==0? route.getPassingBusStations(): dto.getPassingBusStations();
        Route route1 = new Route(
                route.getId(),
                name,
                startingProvince,
                startingDistrict,
                endingProvince,
                endingDistrict,
                originatingStation,
                endingStation,
                passingBusStations
        );
        return route1;

    }
    public static BusReservationHistory createBusReservationHistory(BusReservation busReservation){
        BusReservationHistory busReservationHistory = new BusReservationHistory();
        busReservationHistory.setBusNumber(busReservation.getBusNumber());
        busReservationHistory.setTripId(busReservation.getTripId());
        busReservationHistory.setWeeklyTrip(busReservationHistory.isWeeklyTrip());
        busReservationHistory.setDepatureTime(busReservation.getDepatureTime());
        busReservationHistory.setReservedSeatList(busReservation.getReservedSeatList());
        return busReservationHistory;
    }
}
