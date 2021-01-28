package com.spring.springmongodb.api.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Review {
    private String userName;
    private int rating;
    private String description;
}