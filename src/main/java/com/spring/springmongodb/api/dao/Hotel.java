package com.spring.springmongodb.api.dao;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@Document(collection = "hotels")
public class Hotel {
    @Id
    private String id;
    @NotBlank(message = "{name.not.blank}")
    private String name;
    @Indexed(direction = IndexDirection.ASCENDING)
    @NotNull(message = "{price.not.null}")
    private int pricePerNight;
    @NotNull(message = "{address.not.null}")
    private Address address;
    private List<Review> reviews;

    public Hotel(){
        reviews = new ArrayList<>();
    }
}
