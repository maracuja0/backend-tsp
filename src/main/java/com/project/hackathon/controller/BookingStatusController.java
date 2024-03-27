package com.project.hackathon.controller;

import com.project.hackathon.entity.BookingStatusEntity;
import com.project.hackathon.service.BookingStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path ="/api/booking-status")
public class BookingStatusController {
    @Autowired
    private BookingStatusService bookingStatusService;

    @GetMapping
    public List<BookingStatusEntity> getBookingStatus(){
        return bookingStatusService.getAllStatus();
    }

}
