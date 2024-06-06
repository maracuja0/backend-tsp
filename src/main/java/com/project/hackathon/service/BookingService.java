package com.project.hackathon.service;

import com.project.hackathon.entity.BookingEntity;
import com.project.hackathon.request.StatusRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookingService {
    Long createBooking(BookingEntity booking);

    List<BookingEntity> getAllBooking();

    ResponseEntity<String> deleteBooking(Long id);

    void updateStatus(StatusRequest statusRequest);

//    List<BookingEntity> getBookingByUserId(Long userId);
}
