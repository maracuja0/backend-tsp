package com.project.hackathon.service;

import com.project.hackathon.entity.BookingEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookingService {
    Long createBooking(BookingEntity booking);

    List<BookingEntity> getAllBooking();

    ResponseEntity<String> deleteBooking(Long id);
}
