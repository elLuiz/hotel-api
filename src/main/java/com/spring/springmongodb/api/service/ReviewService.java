package com.spring.springmongodb.api.service;

import com.spring.springmongodb.api.dao.Hotel;
import com.spring.springmongodb.api.dao.Review;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReviewService extends HotelService{

    public Hotel reviewHotel(String id, Review review){
        Hotel hotel = findById(id);
        List<Review> reviews = appendReview(hotel, review);
        hotel.setReviews(reviews);
        return hotelRepository.save(hotel);
    }

    private List<Review> appendReview(Hotel hotel, Review review){
        List<Review> reviews = hotel.getReviews();
        reviews.add(review);

        return reviews;
    }

}
