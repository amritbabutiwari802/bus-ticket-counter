package com.amritbabu.busticketcounter.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Bus {

    @Id
    private String busNumber;

    @ElementCollection
    @CollectionTable(name = "bus_seat_codes")
    @Column(name = "seat_codes")
    private List<String> seatCodes = new ArrayList<>();
}
