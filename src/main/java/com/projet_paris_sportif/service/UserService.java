package com.projet_paris_sportif.service;

import com.projet_paris_sportif.controller.ResourceNotFoundException;
import com.projet_paris_sportif.model.User;
import com.projet_paris_sportif.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User deleteUser(Integer id) throws ResourceNotFoundException {
        User userDelete = userRepository.getReferenceById(id);
        userRepository.delete(userDelete);
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User deleted !"));
    }

    public User getUser(Integer id) {
        return userRepository.getReferenceById(id);
    }

    public boolean loginUser(String username, String password){
        User logUser = userRepository.findByName(username);
        if(logUser == null){
            return false;
        }
        else{
            return Objects.equals(password, logUser.getPassword());
        }
    }
}
