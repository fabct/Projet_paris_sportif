package com.projet_paris_sportif.controller;

import com.projet_paris_sportif.model.InfUser;
import com.projet_paris_sportif.service.InfUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController()
public class InfUserController extends Exception {
    @Autowired
    private InfUserService infUserService;

    @PostMapping("/InfUser")
    public InfUser updateInfUser(@RequestBody InfUser infUser) {
        return infUserService.updateInfUser(infUser);
    }
}
