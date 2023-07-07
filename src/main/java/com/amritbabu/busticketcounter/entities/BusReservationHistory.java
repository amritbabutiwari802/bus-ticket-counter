package com.amritbabu.busticketcounter.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class BusReservationHistory {
    @Id
    @GeneratedValue
    private UUID id;
    private UUID tripId;
    private boolean isWeeklyTrip;
    private String busNumber;
    private Time depatureTime;
    private LocalDate reservationDate;

    @ElementCollection
    @CollectionTable(name = "")
    @Column(name = "seat_codes")
    private List<String> reservedSeatList;
}
