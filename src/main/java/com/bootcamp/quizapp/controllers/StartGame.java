package com.bootcamp.quizapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequestMapping("templates")
public class StartGame {

    // on button click user is redirected to login page
    // easier way is to do it with html, but was good to practice
    @GetMapping("/login")
    public String startGame(){
        return ("login");
    }

    @GetMapping("/")
    public String showFrontPage(){
        return ("index.html");
    }
}
