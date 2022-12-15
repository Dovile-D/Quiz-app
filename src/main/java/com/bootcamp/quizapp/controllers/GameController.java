package com.bootcamp.quizapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController {



    @GetMapping("/")  // OK
    public String showFrontPage(){return ("index");}



    @GetMapping("/selectCategory")  // OK
    public String showSelectCategory(){
        return ("selectCategory");
    }


    @GetMapping("/difficulty") //OK
    public String openLogin(){
        return ("selectDifficulty.html");
    }

    @GetMapping("/playGame") //OK
    public String startGameCategory(){
        return ("game.html");
    }


    @GetMapping("/logout")
    public String logout(){
        return "index";
    }
}
