package com.projet_paris_sportif.controller;

import com.projet_paris_sportif.model.InfUser;
import com.projet_paris_sportif.service.InfUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class InfUserController {
    @Autowired
    private InfUserService infUserService;

    @PostMapping("/InfUser")
    public InfUser updateInfUser(@RequestBody InfUser infUser) {
        return infUserService.updateInfUser(infUser);
    }


}
