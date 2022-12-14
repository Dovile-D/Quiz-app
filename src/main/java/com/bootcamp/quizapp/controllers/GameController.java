package com.bootcamp.quizapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController {

    @GetMapping("/login")  // OK
    public String showLogin(){ return ("login"); }

    @GetMapping("/")  // OK
    public String showFrontPage(){return ("index");}

    @GetMapping("/userOptions")
    public String showRegisteredUserOptions(){ return ("user_option.html"); }

    @GetMapping("/selectCategory")  // OK
    public String showSelectCategory(){
        return ("selectCategory");
    }

    @GetMapping("/singleGameStatistics") // OK
    public String showSingleGameStatistics() { return "singleGameStatistics"; }
//    when user is not a registered one, then the redirect should be back to index.html

    @GetMapping("/difficulty") //OK
    public String openLogin(){
        return ("selectDifficulty.html");
    }

    @GetMapping("/playGame") //OK
    public String startGameCategory(){
        return ("game.html");
    }

    @GetMapping("/statistics")
    public String showFullStatistics(){
        return "user_statistics.html";
    }

    @GetMapping("/logout")
    public String logout(){
        return "index";
    }
}
