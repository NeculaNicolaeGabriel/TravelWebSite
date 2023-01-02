package com.example.Travel_Website_1.Dtos;

import com.example.Travel_Website_1.model.Enum.MealPlan;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor

public class HotelDto {

    private Byte[] image;
    private String city;
    private Integer numberOfRooms;
    private MealPlan mealPlan;
    private Double pricePerNight;

    private Boolean spa;

    private Boolean gym;

    private Boolean transferAiroport;

}
