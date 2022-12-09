package com.bootcamp.quizapp.controllers;

import com.bootcamp.quizapp.controllers.CategoryController;
import com.bootcamp.quizapp.controllers.DifficultyController;
import com.bootcamp.quizapp.controllers.LevelController;
import com.bootcamp.quizapp.controllers.NewUser;
import com.bootcamp.quizapp.controllers.UserLogin;
import com.bootcamp.quizapp.controllers.UserOptions;
import com.bootcamp.quizapp.controllers.GameController;

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
    public String openLogin(){
        return ("login");
    }

    @GetMapping("/")
    public String showFrontPage(){
        return ("index.html");
    }

    @GetMapping("/play")
    public String startGameCategory(){
        return ("user_select_category.html");
    }

//    @GetMapping("")
//    public String returnToUserOptions() {return}
}
