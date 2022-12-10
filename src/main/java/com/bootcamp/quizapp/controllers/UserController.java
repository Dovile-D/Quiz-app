package com.bootcamp.quizapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/registered")
    public String showloginOnRegister(){return "login"; }


    @GetMapping("/registerNew")
    public String newUserRegistration(){return ("register"); }
}
