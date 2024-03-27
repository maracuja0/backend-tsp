package com.project.hackathon.service.Impl;

import com.project.hackathon.entity.BookingStatusEntity;
import com.project.hackathon.repository.BookingStatusRepository;
import com.project.hackathon.service.BookingStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingStatusServiceImpl implements BookingStatusService {
    @Autowired
    private BookingStatusRepository bookingStatusRepository;

    @Override
    public List<BookingStatusEntity> getAllStatus() {
        return bookingStatusRepository.findAll();
    }
}
