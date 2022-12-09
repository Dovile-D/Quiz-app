package com.bootcamp.quizapp.controllers;

import com.bootcamp.quizapp.controllers.StartGame;
import com.bootcamp.quizapp.controllers.CategoryController;
import com.bootcamp.quizapp.controllers.DifficultyController;
import com.bootcamp.quizapp.controllers.LevelController;
import com.bootcamp.quizapp.controllers.NewUser;
import com.bootcamp.quizapp.controllers.UserLogin;
import com.bootcamp.quizapp.controllers.GameController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserOptions {
//    @GetMapping("/playUserGame")
//    public String userWantsToPlay() { return "user_select_category.html"; }

    @GetMapping("/statistics")
    public String showFullStatistics(){
        return "user_statistics.html";
    }
}
