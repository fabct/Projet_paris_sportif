package com.projet_paris_sportif.service;

import com.projet_paris_sportif.model.InfUser;
import com.projet_paris_sportif.model.User;
import com.projet_paris_sportif.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private InfUserService infUserService;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User deleteUser(Integer id) {
        User userDelete = userRepository.getReferenceById(id);
        userRepository.delete(userDelete);
        InfUser infUser = infUserService.deleteInfUser(id);
        return userDelete;
    }

    public User getUser(Integer id) {
        return userRepository.getReferenceById(id);
    }
}
