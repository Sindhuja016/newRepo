package com.userdemo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userdemo.model.UserModel;
import com.userdemo.service.UserService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;  

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    public List<UserModel> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/get/{userId}")
    public Optional<UserModel> getUser(@PathVariable("userId") Integer userId) {
        return userService.getUserById(userId);
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable("userId") Integer userId) {
        userService.delete(userId);
    }

    @PostMapping("/create-users")
    public List<UserModel> saveUsers(@RequestBody List<UserModel> users) {
        return userService.saveOrUpdateAll(users);
    }
    @PutMapping("/update/{userId}")
    public UserModel updateUserById(@RequestBody UserModel updatedUser, @PathVariable("userId") Integer userId) {
    	updatedUser.setId(userId); 
    	return userService.updateUserById(updatedUser);
    	}


}


