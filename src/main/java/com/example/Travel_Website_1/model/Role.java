package com.example.Travel_Website_1.model;


import com.example.Travel_Website_1.model.Enum.Type;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;


    @Enumerated(value = EnumType.STRING)
    private Type type;






}
