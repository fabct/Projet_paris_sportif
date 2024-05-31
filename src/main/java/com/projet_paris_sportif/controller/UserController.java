package com.projet_paris_sportif.controller;

import com.projet_paris_sportif.dto.LoginDto;
import com.projet_paris_sportif.model.User;
import com.projet_paris_sportif.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class UserController extends Exception {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public User getUser(@RequestParam Integer id) throws ResourceNotFoundException {
        return userService.getUser(id);
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/login")
    public Integer login(@RequestBody LoginDto login)
            throws ResourceNotFoundException {
        return userService.loginUser(login);
    }

    @DeleteMapping("/user")
    public User deleteUser(@RequestParam Integer id) throws ResourceNotFoundException {
        return userService.deleteUser(id);
    }

    @PutMapping("/addFunds")
    public Integer addFunds(@RequestParam Integer userId, @RequestParam Integer amount) {
        return userService.addFunds(userId, amount);
    }

}
