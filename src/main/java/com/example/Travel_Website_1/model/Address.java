package com.example.Travel_Website_1.model;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private  Long userId;

    private Long addressId;
    private String streetName;
    private Integer streetNumber;
    private Character stairCase;
    private Integer apartament;


    @OneToOne
    private User user;



}
