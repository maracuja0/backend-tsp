package com.project.hackathon.service;

import com.project.hackathon.entity.BookingEntity;
import com.project.hackathon.entity.LikedEntity;
import com.project.hackathon.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserEntity> getAllUsers();

    Optional<UserEntity> getUserById(Long userId);

    void addUser(UserEntity userId);

    List<BookingEntity> getBookingByUser(UserEntity user);

    List<LikedEntity> getLikedByUser(UserEntity user);
}
