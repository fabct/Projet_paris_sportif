package com.projet_paris_sportif.controller;

import com.projet_paris_sportif.model.User;
import com.projet_paris_sportif.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

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

    @DeleteMapping("/user")
    public Boolean deleteUser(@RequestParam Integer id) {
        return userService.deleteUser(id);
    }
}
