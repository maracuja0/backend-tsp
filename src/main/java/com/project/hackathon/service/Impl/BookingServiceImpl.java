package com.project.hackathon.service.Impl;

import com.project.hackathon.entity.BookingEntity;
import com.project.hackathon.repository.BookingRepository;
import com.project.hackathon.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public List<BookingEntity> getAllBooking() {
        return bookingRepository.findAll();
    }

    @Override
    public Long createBooking(BookingEntity booking) {
        return bookingRepository.save(booking).getId();
    }

    @Override
    public ResponseEntity<String> deleteBooking(Long id) {
        bookingRepository.deleteById(id);
        return ResponseEntity.ok("Delete was success");
    }
}
