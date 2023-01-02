package com.example.Travel_Website_1.Dtos;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class UserDto {


    private Long addressId;
    private String phoneNumber;
    private String email;

}
