package com.project.hackathon.service.Impl;

import com.project.hackathon.entity.BookingEntity;
import com.project.hackathon.entity.BookingStatusEntity;
import com.project.hackathon.repository.BookingRepository;
import com.project.hackathon.repository.BookingStatusRepository;
import com.project.hackathon.request.StatusRequest;
import com.project.hackathon.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BookingStatusRepository bookingStatusRepository;

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

    @Override
    public void updateStatus(StatusRequest statusRequest) {
        Long bookingId = statusRequest.getBookingId();
        Long statusId = statusRequest.getStatusId();

        Optional<BookingEntity> bookingOptional = bookingRepository.findById(bookingId);
        BookingEntity booking = bookingOptional.get();
        System.out.println(booking);
        Optional<BookingStatusEntity> status = bookingStatusRepository.findById(statusId);
        BookingStatusEntity bookingStatus = status.get();
        booking.setBookingStatusId(bookingStatus);
        bookingRepository.save(booking);
        System.out.println(booking.getBookingStatusId());
    }
}
