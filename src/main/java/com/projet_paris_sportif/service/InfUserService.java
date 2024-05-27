package com.projet_paris_sportif.service;

import com.projet_paris_sportif.model.InfUser;
import com.projet_paris_sportif.repository.InfUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class InfUserService {

    @Autowired
    private InfUserRepository repository;

    public InfUser updateInfUser(InfUser infUser) {
        return repository.save(infUser);
    }

    public InfUser deleteInfUser(Integer id) {
        InfUser infUser = repository.findById(id).orElse(null);
        repository.delete(infUser);
        return infUser;
    }
}
