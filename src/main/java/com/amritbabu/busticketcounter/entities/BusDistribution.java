package com.amritbabu.busticketcounter.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bus_distribution")
public class BusDistribution {

    @Id
    @GeneratedValue
    private int id;

    private String busNumber;
    private UUID tripId;
    private boolean isWeeklyTrip;
    private boolean isTripWeekely;
}
