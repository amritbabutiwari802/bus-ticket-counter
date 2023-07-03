package com.amritbabu.busticketcounter.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Time;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class WeeklyTrip {

    private UUID id;
    private int day;
    private Time time;
    // LIst<Bus> busList;
}
