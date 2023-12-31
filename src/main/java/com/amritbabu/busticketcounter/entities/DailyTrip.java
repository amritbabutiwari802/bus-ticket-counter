package com.amritbabu.busticketcounter.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Time;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity()
public class DailyTrip {

    @Id
    @GeneratedValue
    private UUID iD;
    private UUID routeId;
    private Time time;


}
