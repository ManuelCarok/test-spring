package com.test.api.models;

import lombok.Getter;
import lombok.Setter;

public class User {
    @Getter @Setter
    private String message;
    @Getter @Setter
    private String email;
    @Getter @Setter
    private String password;
    @Getter @Setter
    private Phone[] phones;

    public User(String message, String email, String password, Phone[] phones) {
        this.message = message;
        this.email = email;
        this.password = password;
        this.phones = phones;
    }
}

