package com.spring.springmongodb.api.service;

import com.spring.springmongodb.api.dao.Hotel;
import com.spring.springmongodb.api.exception.client.EntityNotFound;
import com.spring.springmongodb.api.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class HotelService {
    @Autowired
    protected HotelRepository hotelRepository;

    protected Hotel findById(String id){
        return hotelRepository.findById(id)
                .orElseThrow(() -> new EntityNotFound("Hotel not found"));
    }
}
