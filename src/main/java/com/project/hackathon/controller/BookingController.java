package com.project.hackathon.controller;

import com.project.hackathon.entity.BookingEntity;
import com.project.hackathon.request.StatusRequest;
import com.project.hackathon.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="/api/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping
    public List<BookingEntity> getAllBooking(){
        return bookingService.getAllBooking();
    }

    @PostMapping
    public Long createBooking(@RequestBody @Valid BookingEntity booking){
        return bookingService.createBooking(booking);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable("id") Long id){
        return bookingService.deleteBooking(id);
    }

    @PostMapping("/updateStatus")
    public void updateBookingStatus(@RequestBody StatusRequest statusRequest){
        bookingService.updateStatus(statusRequest);
    }

}
