package com.amritbabu.busticketcounter.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class BusReservation {

    @Id
    @GeneratedValue
    private UUID id;
    private UUID tripId;
    private boolean isWeeklyTrip;
    private String busNumber;
    private Time depatureTime;
    private List<String> reservedSeatList = new ArrayList<>();
}
