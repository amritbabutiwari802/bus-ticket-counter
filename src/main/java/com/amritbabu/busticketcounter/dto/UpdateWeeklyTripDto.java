package com.amritbabu.busticketcounter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Time;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UpdateWeeklyTripDto {
    private Integer day;
    private Time time;
}
