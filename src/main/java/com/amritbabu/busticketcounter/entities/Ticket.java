package com.amritbabu.busticketcounter.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Ticket {

    private UUID id;
    private String passengerName;
    private UUID reservationID;
    private UUID tripId;
    private String busNumber;
    private String seatCode;
    private BusStation departureStation;
    private BusStation destinationStation;
    private LocalDate departureDate;

}
