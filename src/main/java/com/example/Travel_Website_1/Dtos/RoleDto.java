package com.example.Travel_Website_1.Dtos;

import com.example.Travel_Website_1.model.Enum.Type;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoleDto {

    private Long id;

    private Type type;

}
