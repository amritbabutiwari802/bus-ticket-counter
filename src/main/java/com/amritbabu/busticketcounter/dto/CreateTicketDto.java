package com.amritbabu.busticketcounter.dto;

import com.amritbabu.busticketcounter.entities.BusReservation;
import com.amritbabu.busticketcounter.entities.BusStation;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class CreateTicketDto {
    private String passengerName;
    private UUID busReservationId;
    private String seatCode;
    private UUID departureStationID;
    private UUID destinationStationId;
}
