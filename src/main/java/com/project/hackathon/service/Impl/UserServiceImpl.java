package com.project.hackathon.service.Impl;

import com.project.hackathon.entity.UserEntity;
import com.project.hackathon.repository.UserRepository;
import com.project.hackathon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getUserById(Long userId) {
        return null;
    }

    //TODO: написать проверку на то, что пользователь уже существует
    @Override
    public void addUser(UserEntity user) {
//        user.setUniversityID(university); // связать пользователя с университетом
        userRepository.save(user);
//        return userRepository.findByUserEmail(user.getEmail());
    }


}
