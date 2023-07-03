package com.amritbabu.busticketcounter.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Route {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private String startingProvince;

    private String startingDistrict;

    private String endingProvince;

    private String endingDistrict;

    private BusStation originationStation;

    private BusStation endingStation;

    private List<BusStation> passingBusStations = new ArrayList<>();

}
