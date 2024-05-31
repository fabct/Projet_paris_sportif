package com.projet_paris_sportif.service;

import com.projet_paris_sportif.controller.ResourceNotFoundException;
import com.projet_paris_sportif.dto.LoginDto;
import com.projet_paris_sportif.dto.UserDto;
import com.projet_paris_sportif.model.User;
import com.projet_paris_sportif.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;

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
        return userRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Cet utilisateur n'existe pas ou a bien été supprimé !"));
    }

    public User getUser(Integer id) throws ResourceNotFoundException {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cet utilisateur n'existe pas !"));
    }

    public Integer loginUser(LoginDto login) throws ResourceNotFoundException {
        User logUser = userRepository.findByName(login.getUsername())
                .orElseThrow(() -> new ResourceNotFoundException("Ce pseudo ne correspond pas à un utilisateur !"));
        if (Objects.equals(login.getPassword(), logUser.getPassword()))
            return logUser.getId();
        return 0;
    }
}
