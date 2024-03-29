package com.project.hackathon.service.Impl;

import com.project.hackathon.entity.BookingEntity;
import com.project.hackathon.entity.LikedEntity;
import com.project.hackathon.entity.UserEntity;
import com.project.hackathon.repository.BookingRepository;
import com.project.hackathon.repository.LikedRepository;
import com.project.hackathon.repository.UserRepository;
import com.project.hackathon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    LikedRepository likedRepository;

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserEntity> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    //TODO: написать проверку на то, что пользователь уже существует
    @Override
    public void addUser(UserEntity user) {
//        user.setUniversityID(university); // связать пользователя с университетом
        userRepository.save(user);
//        return userRepository.findByUserEmail(user.getEmail());
    }

    @Override
    public List<BookingEntity> getBookingByUser(UserEntity user) {
        return bookingRepository.findByUserId(user);
    }

    @Override
    public List<LikedEntity> getLikedByUser(UserEntity user) {
        return likedRepository.findByUserId(user);
    }

}
