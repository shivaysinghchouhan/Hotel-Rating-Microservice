package com.user.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hotel {
    private Integer hotelId;
    private String hotelName;
    private String hotelLocation;
    private String aboutHotel;
    
    
}
