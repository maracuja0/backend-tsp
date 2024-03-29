package com.project.hackathon.controller;

import com.project.hackathon.entity.BookingEntity;
import com.project.hackathon.entity.LikedEntity;
import com.project.hackathon.entity.UserEntity;
import com.project.hackathon.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path ="/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserEntity> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/{userId}/booking")
    public ResponseEntity<List<BookingEntity>> getBookingByUserId(@PathVariable Long userId){
        Optional<UserEntity> userOptional = userService.getUserById(userId);
        if (userOptional.isPresent()) {
            UserEntity user = userOptional.get();
            List<BookingEntity> booking = userService.getBookingByUser(user);
            return ResponseEntity.ok(booking);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{userId}/liked")
    public ResponseEntity<List<LikedEntity>> getLikedByUserId(@PathVariable Long userId){
        Optional<UserEntity> userOptional = userService.getUserById(userId);
        if (userOptional.isPresent()) {
            UserEntity user = userOptional.get();
            List<LikedEntity> liked = userService.getLikedByUser(user);
            return ResponseEntity.ok(liked);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/registration")
    public void addUser(@RequestBody @Valid UserEntity user){
        userService.addUser(user);
    }

}
