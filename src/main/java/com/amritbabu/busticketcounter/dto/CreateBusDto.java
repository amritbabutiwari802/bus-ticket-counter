package com.amritbabu.busticketcounter.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateBusDto {

    @NonNull
    private String busNumber;
    private List<String> seatCodes;

}
