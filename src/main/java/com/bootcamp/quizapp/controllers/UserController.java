package com.bootcamp.quizapp.controllers;

import com.bootcamp.quizapp.dto.RegistrationRequestDto;
import com.bootcamp.quizapp.models.User;
import com.bootcamp.quizapp.repositories.UserRepository;
import com.bootcamp.quizapp.services.RegistrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final RegistrationService registrationService;
    private final UserRepository userRepository;

    @GetMapping("/registerNew")
    public ModelAndView showloginOnRegister(ModelMap model){
        return new ModelAndView ("register.html", model); }

//    @RequestBody RegistrationRequestDto registrationRequestDto

    @GetMapping("/registered")
    public ModelAndView newUserRegistration(@RequestParam(name = "name") String formName,
                                            @RequestParam(name = "email") String formEmail,
                                            @RequestParam(name = "password") String formPassword,
                                            ModelMap model){


        User newUser = registrationService.register(formName, formEmail, formPassword);

        userRepository.save(newUser);

        return new ModelAndView("login.html", model); }


}
