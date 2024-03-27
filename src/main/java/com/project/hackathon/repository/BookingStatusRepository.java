package com.project.hackathon.repository;

import com.project.hackathon.entity.BookingStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingStatusRepository extends JpaRepository<BookingStatusEntity, Long> {
}
