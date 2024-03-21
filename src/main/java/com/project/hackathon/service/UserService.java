package com.project.hackathon.service;

import com.project.hackathon.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> getAllUsers();

    UserEntity getUserById(Long userId);

    void addUser(UserEntity user);
}
