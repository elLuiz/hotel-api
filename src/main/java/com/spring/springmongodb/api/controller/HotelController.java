package com.spring.springmongodb.api.controller;

import com.spring.springmongodb.api.dao.Address;
import com.spring.springmongodb.api.dao.Hotel;
import com.spring.springmongodb.api.service.HotelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/hotel")
public class HotelController {
    @Autowired
    private HotelServiceImpl hotelService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Hotel addHotel(@Valid @RequestBody Hotel hotel){
        return hotelService.addHotel(hotel);
    }

    @GetMapping
    public List<Hotel> listHotels(){
        return hotelService.listHotels();
    }

    @PutMapping("/{hotelId}")
    public Hotel updateHotelAddress(@PathVariable String hotelId, @Valid @RequestBody Address address){
        return hotelService.updateHotelAddress(hotelId, address);
    }

    @DeleteMapping("/{hotelId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteHotel(@PathVariable String hotelId){
        hotelService.deleteHotel(hotelId);
    }
}
