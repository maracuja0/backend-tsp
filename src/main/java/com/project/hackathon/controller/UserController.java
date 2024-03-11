package com.project.hackathon.controller;

import com.project.hackathon.entity.UserEntity;
import com.project.hackathon.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserEntity> getAllUsers(){
        return userService.getAllUsers();

    }
    @GetMapping("/{userId}")
    public UserEntity getUserById(@PathVariable Long userId){
        //        System.out.println("userId:  "+ userId+", user :" + user);
        return userService.getUserById(userId);
    }
}
