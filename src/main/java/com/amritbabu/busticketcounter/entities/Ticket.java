package com.amritbabu.busticketcounter.entities;

import jakarta.persistence.*;
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

    @Id
    @GeneratedValue
    private UUID id;
    private String passengerName;

    @OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH })
    private BusReservation busReservation;
    private String seatCode;
    private BusStation departureStation;
    private BusStation destinationStation;
    private LocalDate departureDate;

}
