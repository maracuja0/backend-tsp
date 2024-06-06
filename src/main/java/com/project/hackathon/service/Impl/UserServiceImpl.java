package com.project.hackathon.service.Impl;

import com.project.hackathon.entity.*;
import com.project.hackathon.repository.*;
import com.project.hackathon.request.LoginRequest;
import com.project.hackathon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    BookingStatusRepository bookingStatusRepository;

    @Autowired
    LikedRepository likedRepository;

    @Autowired
    PositionRepository positionRepository;

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

    @Override
    public UserEntity login(LoginRequest user) {
        String mailCheck = user.getUserEmail();
        String passwordCheck = user.getUserPassword();

        Optional<UserEntity> personOptional = userRepository.findByEmail(mailCheck);

        if (personOptional.isEmpty()) {
            return null;  // Пользователь не найден
        }

        UserEntity userEntity = personOptional.get();

        if (userEntity.getPassword().equals(passwordCheck)) {
            return userEntity; // Пароль верный, возвращаем пользователя
        } else {
            return null; // Неверный пароль
        }

    }

    @Override
    public void addLikedByUserId(Long userId, Long positionId) {
        Optional<UserEntity> userOptional = userRepository.findById(userId);
        Optional<PositionEntity> positionOptional = positionRepository.findById(positionId);
        LikedEntity liked = new LikedEntity();
        liked.setUserId(userOptional.get());
        liked.setPositionId(positionOptional.get());
        liked.setDate(LocalDate.now());

        likedRepository.save(liked);
    }

    @Override
    public void addBookingByUserId(Long userId, Long positionId) {
        Optional<UserEntity> userOptional = userRepository.findById(userId);
        Optional<PositionEntity> positionOptional = positionRepository.findById(positionId);

        BookingEntity booking = new BookingEntity();
        booking.setUserId(userOptional.get());
        booking.setPositionId(positionOptional.get());
        booking.setDate(LocalDate.now());
        Optional<BookingStatusEntity> bookingStatusOptional = bookingStatusRepository.findById(0L);
        booking.setBookingStatusId(bookingStatusOptional.get());

        bookingRepository.save(booking);
    }
}
