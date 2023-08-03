package com.test.api.models;

import lombok.*;

import javax.validation.constraints.Pattern;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class User {
    private String name;
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@([A-Za-z0-9.-]+\\.[A-Za-z]{2,3})$", message = "El formato de correo es inválido")
    private String email;
    @Pattern(regexp = "^[A-Z][a-z]*[0-9]{2}$", message = "El formato de password es inválido")
    private String password;
    private Phone[] phones;
}

