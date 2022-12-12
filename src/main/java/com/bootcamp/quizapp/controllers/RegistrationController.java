package com.bootcamp.quizapp.controllers;

import com.bootcamp.quizapp.models.RegistrationRequestDto;
import com.bootcamp.quizapp.services.RegistrationService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    public String register(@RequestBody RegistrationRequestDto request) {
        return registrationService.register(request);
    }
}
