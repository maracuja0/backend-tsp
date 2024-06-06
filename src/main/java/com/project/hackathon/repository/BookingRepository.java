package com.project.hackathon.repository;

import com.project.hackathon.entity.BookingEntity;
import com.project.hackathon.entity.PositionEntity;
import com.project.hackathon.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<BookingEntity, Long> {
    List<BookingEntity> findByUserId(UserEntity user);

    List<BookingEntity> findByPositionId(PositionEntity positionId);
}
