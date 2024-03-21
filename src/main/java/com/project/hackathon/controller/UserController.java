package com.project.hackathon.controller;

import com.project.hackathon.entity.UserEntity;
import com.project.hackathon.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserEntity> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/{userId}")
    public UserEntity getUserById(@PathVariable Long userId){
        return userService.getUserById(userId);
    }

    @PostMapping("/registration")
    public void addUser(@RequestBody @Valid UserEntity user){
        userService.addUser(user);
    }


}
