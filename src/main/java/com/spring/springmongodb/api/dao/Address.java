package com.spring.springmongodb.api.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
public class Address {
    @NotBlank
    private String city;
    @NotBlank
    private String country;
}
