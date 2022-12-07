package com.bootcamp.quizapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserOptions {

    @GetMapping("/selectCategory")
    public String userWantsToPlay(){
        return "user_select_category.html";
    }

    @GetMapping("/statistics")
    public String userWantsToSeeFullStatistics(){
        return "user_statistics.html";
    }
}
