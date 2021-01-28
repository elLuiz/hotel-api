package com.spring.springmongodb.api.controller;

import com.spring.springmongodb.api.dao.Hotel;
import com.spring.springmongodb.api.dao.Review;
import com.spring.springmongodb.api.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/hotel/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping("/{hotelId}")
    public Hotel reviewHotel(@PathVariable String hotelId, @RequestBody Review review){
        return reviewService.reviewHotel(hotelId, review);
    }
}
