package com.amritbabu.busticketcounter.entities;

import jakarta.persistence.*;
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

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH })
    private List<BusStation> passingBusStations = new ArrayList<>();

    public Route(String name, String startingProvince, String startingDistrict, String endingProvince, String endingDistrict, BusStation originationStation, BusStation endingStation, List<BusStation> passingBusStations) {
        this.name = name;
        this.startingProvince = startingProvince;
        this.startingDistrict = startingDistrict;
        this.endingProvince = endingProvince;
        this.endingDistrict = endingDistrict;
        this.originationStation = originationStation;
        this.endingStation = endingStation;
        this.passingBusStations = passingBusStations;
    }
}
