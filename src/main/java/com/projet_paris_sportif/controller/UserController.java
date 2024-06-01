package com.projet_paris_sportif.controller;

import com.projet_paris_sportif.dto.user.UserRequestDTO;
import com.projet_paris_sportif.dto.user.UserResponseDTO;
import com.projet_paris_sportif.dto.user.LoginDto;
import com.projet_paris_sportif.model.InfUser;
import com.projet_paris_sportif.model.User;
import com.projet_paris_sportif.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "*")
@RestController
public class UserController extends Exception {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public UserResponseDTO getUser(@RequestParam Integer id) throws ResourceNotFoundException {
        return userService.getUser(id);
    }

    @GetMapping("/allUsers")
    public List<UserResponseDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/user")
    public UserResponseDTO createUser(@RequestBody UserRequestDTO user) {
        return userService.createUser(user);
    }

    @PostMapping("/modifyUser")
    public void modifyUser(@RequestBody InfUser infUser) {
        userService.modifyUser(infUser);
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

    @PostMapping("/addFunds")
    public Integer addFunds(@RequestParam Integer userId, @RequestParam Integer amount) {
        return userService.addFunds(userId, amount);
    }

}
