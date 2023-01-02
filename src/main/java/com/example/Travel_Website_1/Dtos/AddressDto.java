package com.example.Travel_Website_1.Dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDto {
    private Long userId;
    private String streetName;
    private Integer streetNumber;
    private Character staircase;
    private Integer apartment;
}
