package com.example.Travel_Website_1.model;


import com.example.Travel_Website_1.model.Enum.MealPlan;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Hotel")
@Data
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hotelId;
    private String hotelName;

    @Lob
    private Byte[] image;

    private String city;
    private Integer numberOfRooms;

    @Enumerated(value = EnumType.STRING)
    private MealPlan mealPlan;

    private Double pricePerNight;

    private Boolean spa;

    private Boolean gym;

    private Boolean transferAiroport;

    private int night;
}


