package com.amritbabu.busticketcounter.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    private List<String> seatCodes = new ArrayList<>();
}
