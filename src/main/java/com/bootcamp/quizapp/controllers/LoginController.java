package com.bootcamp.quizapp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
public class LoginController {

//    // Login form
//    @RequestMapping("/login.html")
//    public String login() {
//        return "login.html";
//    }

    @GetMapping("/login")  // OK
    public ModelAndView showLogin(ModelMap model){

        return new ModelAndView("login.html", model); }
}


//    // Login form with error
//    @RequestMapping("/login-error.html")
//    public String loginError(Model model) {
//        model.addAttribute("loginError", true);
//        return "login.html";
//    }


