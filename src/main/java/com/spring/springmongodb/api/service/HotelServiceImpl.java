package com.spring.springmongodb.api.service;

import com.spring.springmongodb.api.dao.Address;
import com.spring.springmongodb.api.dao.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl extends HotelService{

    public Hotel addHotel(Hotel hotel){
        return hotelRepository.insert(hotel);
    }

    public List<Hotel> listHotels(){
        return hotelRepository.findAll();
    }

    public Hotel updateHotelAddress(String id, Address address){
        Hotel hotel = findById(id);
        hotel.setAddress(address);
        return hotelRepository.save(hotel);
    }

    public void deleteHotel(String id){
        Hotel hotel = findById(id);
        hotelRepository.delete(hotel);
    }
}
