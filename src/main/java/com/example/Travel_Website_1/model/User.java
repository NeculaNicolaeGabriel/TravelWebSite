package com.example.Travel_Website_1.model;


import com.example.Travel_Website_1.model.Enum.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name="users")
@Data

@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String username;


    private String password;
    private String cnp;
    private String phoneNumber;


    private String email;


    @ManyToOne
    private Role role;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    private Double discountLevel;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;


//    @OneToMany()
//    private Booking booking;



}
