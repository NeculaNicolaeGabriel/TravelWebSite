package com.example.Travel_Website_1.model;


import com.example.Travel_Website_1.model.Enum.MealPlan;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data


//@Table(name="booking")
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @ManyToOne
    private User user;
    @ManyToOne
    private Hotel hotel;

    private Integer bookedRooms;
    private Integer numberOfPersons;
    private Double price;
    @Enumerated(value = EnumType.STRING)
    private MealPlan mealPlan;

    private Date startDate;
    private Date endDate;
    private Date bookingCreateDate;
    private Double facilitiesAdditionalPrice;




}
