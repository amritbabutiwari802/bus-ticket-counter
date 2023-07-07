package com.amritbabu.busticketcounter.dto;

import lombok.*;
import org.springframework.lang.Nullable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BusStationUpdateDto {

    @Nullable
    private double latitude;
    @Nullable
    private double longitude;
    @Nullable
    private String name;
    @Nullable
    private String province;
    @Nullable
    private String district;
    @Nullable
    private String municipality;

    public Double getLongitude(){
        return this.longitude;
    }

    public Double getLatitude(){
        return this.latitude;
    }

}
