package com.test.api.models;

import lombok.Getter;
import lombok.Setter;

public class Phone {
    @Getter @Setter
    private String number;
    @Getter @Setter
    private String citycode;
    @Getter @Setter
    private String contrycode;

    public Phone(String number, String citycode, String contrycode) {
        this.number = number;
        this.citycode = citycode;
        this.contrycode = contrycode;
    }
}
