package com.projet_paris_sportif.service;

import com.projet_paris_sportif.controller.ResourceNotFoundException;
import com.projet_paris_sportif.dto.user.LoginDto;
import com.projet_paris_sportif.dto.user.UserRequestDTO;
import com.projet_paris_sportif.dto.user.UserResponseDTO;
import com.projet_paris_sportif.mapper.UserMapper;
import com.projet_paris_sportif.model.InfUser;
import com.projet_paris_sportif.model.User;
import com.projet_paris_sportif.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        final User user = userMapper.userRequestDTOToUser(userRequestDTO);
        final User response = userRepository.save(user);
        return userMapper.userToUserResponseDTO(response);
    }

    public void modifyUser(InfUser infUser) {
        final User user = userRepository.getReferenceById(infUser.getId());
        user.setBirthyear(infUser.getBirthyear());
        user.setName(infUser.getName());
        user.setSurname(infUser.getSurname());
        user.setPassword(infUser.getPassword());
        user.setRole(infUser.getRole());
        userRepository.save(user);
    }

    public User deleteUser(Integer id) throws ResourceNotFoundException {
        User userDelete = userRepository.getReferenceById(id);
        userRepository.delete(userDelete);
        return userRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Cet utilisateur n'existe pas ou a bien été supprimé !"));
    }

    public UserResponseDTO getUser(Integer id) throws ResourceNotFoundException {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return userMapper.userToUserResponseDTO(user);
    }

    public Integer loginUser(LoginDto login) throws ResourceNotFoundException {
        User logUser = userRepository.findByName(login.getUsername())
                .orElseThrow(() -> new ResourceNotFoundException("Ce pseudo ne correspond pas à un utilisateur !"));
        if (Objects.equals(login.getPassword(), logUser.getPassword()))
            return logUser.getId();
        return 0;
    }

    public List<UserResponseDTO> getAllUsers() {
        final List<User> user = userRepository.findAll();
        return user.stream().map(userMapper::userToUserResponseDTO).collect(Collectors.toList());
    }

    public Integer addFunds(Integer userId, Integer amount) {
        User user = userRepository.findById(userId).get();
        Integer solde = user.getSolde();
        Integer newSolde = solde + amount;
        user.setSolde(newSolde);
        userRepository.save(user);
        return amount;
    }
}
