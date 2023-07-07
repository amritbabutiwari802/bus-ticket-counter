package com.amritbabu.busticketcounter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UnassignBusToTripDto {
    private UUID tripId;
    private boolean isTripWeekely;
}
