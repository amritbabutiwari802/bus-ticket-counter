package com.amritbabu.busticketcounter.dto;

import com.amritbabu.busticketcounter.entities.BusStation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateRouteDto {
    @NonNull
    private String name;

    @NonNull
    private String startingProvince;

    @NonNull
    private String startingDistrict;

    @NonNull
    private String endingProvince;

    @NonNull
    private String endingDistrict;

    @NonNull
    private BusStation originationStation;

    @NonNull
    private BusStation endingStation;

    @NonNull
    private List<BusStation> passingBusStations = new ArrayList<>();
}
