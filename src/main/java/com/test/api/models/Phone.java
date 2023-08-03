package com.test.api.models;

import lombok.*;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Phone {
    private String number;
    private String citycode;
    private String contrycode;
}
