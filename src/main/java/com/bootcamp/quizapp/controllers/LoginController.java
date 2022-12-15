package com.bootcamp.quizapp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

//    // Login form
//    @RequestMapping("/login.html")
//    public String login() {
//        return "login.html";
//    }

    @GetMapping("/login")  // OK
    public String showLogin(){ return ("login kuku "); }
}


//    // Login form with error
//    @RequestMapping("/login-error.html")
//    public String loginError(Model model) {
//        model.addAttribute("loginError", true);
//        return "login.html";
//    }


