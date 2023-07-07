package com.amritbabu.busticketcounter.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.sql.Time;

@Data
@NoArgsConstructor
public class UpdateDailyTripDto {
    @NonNull
    private Time time;
}
