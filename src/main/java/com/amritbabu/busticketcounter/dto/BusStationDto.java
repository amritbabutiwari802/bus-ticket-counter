package com.amritbabu.busticketcounter.dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BusStationDto {

    @NonNull
    private double latitude;
    @NonNull
    private double longitude;
    @NonNull
    private String name;
    @NonNull
    private String province;
    @NonNull
    private String district;
    @NonNull
    private String municipality;
}
