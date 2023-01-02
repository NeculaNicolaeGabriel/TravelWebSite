package com.example.Travel_Website_1.Dtos;


import com.example.Travel_Website_1.model.Enum.MealPlan;
import com.example.Travel_Website_1.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class BookingDTO {

    private Long userId;
    private Long hotelId;
    private Integer bookedRooms;
    private Integer numberOfPersons;
    private Double price;
    private MealPlan mealPlan;
    private Date startDate;
    private Date endDate;
    private Date bookingCreateDate;
    private Double facilitiesAdditionalPrice;


}
