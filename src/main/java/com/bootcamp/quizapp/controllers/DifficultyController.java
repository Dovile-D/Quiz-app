package com.bootcamp.quizapp.controllers;

import com.bootcamp.quizapp.controllers.StartGame;
import com.bootcamp.quizapp.controllers.CategoryController;
import com.bootcamp.quizapp.controllers.LevelController;
import com.bootcamp.quizapp.controllers.NewUser;
import com.bootcamp.quizapp.controllers.UserLogin;
import com.bootcamp.quizapp.controllers.UserOptions;
import com.bootcamp.quizapp.controllers.GameController;

import com.bootcamp.quizapp.controllers.StartGame;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DifficultyController {
    @GetMapping("/difficulty")
    public String openLogin(){
        return ("user_select_dificulty.html");
    }

    @GetMapping("/playGame")
    public String startGameCategory(){
        return ("game.html");
    }
}
