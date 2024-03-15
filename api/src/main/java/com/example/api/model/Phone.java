package com.example.api.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Phone {
    private String number;
    private String citycode;
    private String countrycode;

}
