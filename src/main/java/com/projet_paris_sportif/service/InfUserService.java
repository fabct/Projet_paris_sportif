package com.projet_paris_sportif.service;

import com.projet_paris_sportif.controller.ResourceNotFoundException;
import com.projet_paris_sportif.model.InfUser;
import com.projet_paris_sportif.repository.InfUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfUserService {

    @Autowired
    private InfUserRepository infUserRepository;

    public InfUser updateInfUser(InfUser infUser) {
        return infUserRepository.save(infUser);
    }

    public InfUser deleteInfUser(Integer id) throws ResourceNotFoundException {
        InfUser infUser = infUserRepository.getReferenceById(id);
        infUserRepository.delete(infUser);
        return infUserRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(
                        "Les informations de l'utilisateur n'existent pas ou ont bien été supprimées !"));
    }
}
