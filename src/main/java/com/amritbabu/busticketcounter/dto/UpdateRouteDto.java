package com.amritbabu.busticketcounter.dto;

import com.amritbabu.busticketcounter.entities.BusStation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UpdateRouteDto {
    @Nullable
    private String name;

    @Nullable
    private String startingProvince;

    @Nullable
    private String startingDistrict;

    @Nullable
    private String endingProvince;

    @Nullable
    private String endingDistrict;

    @Nullable
    private BusStation originationStation;

    @Nullable
    private BusStation endingStation;

    @Nullable
    private List<BusStation> passingBusStations = new ArrayList<>();
}
