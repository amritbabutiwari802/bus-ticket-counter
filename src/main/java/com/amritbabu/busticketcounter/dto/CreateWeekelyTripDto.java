package com.amritbabu.busticketcounter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Time;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateWeekelyTripDto {
    private UUID routeId;
    private int day;
    private Time time;
}
