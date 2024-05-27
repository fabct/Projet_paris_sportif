package com.projet_paris_sportif.controller;

import com.projet_paris_sportif.model.User;
import com.projet_paris_sportif.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController extends Exception {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public User getUser(@RequestParam Integer id) {
        return userService.getUser(id);
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/login")
    public Boolean login(@RequestParam String username, @RequestParam String password){
       return userService.loginUser(username,password);
    }

    @DeleteMapping("/user")
    public User deleteUser(@RequestParam Integer id) throws ResourceNotFoundException {
        return userService.deleteUser(id);
    }
}
