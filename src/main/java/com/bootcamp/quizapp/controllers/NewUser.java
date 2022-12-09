package com.bootcamp.quizapp.controllers;

import com.bootcamp.quizapp.controllers.StartGame;
import com.bootcamp.quizapp.controllers.CategoryController;
import com.bootcamp.quizapp.controllers.DifficultyController;
import com.bootcamp.quizapp.controllers.LevelController;
import com.bootcamp.quizapp.controllers.UserLogin;
import com.bootcamp.quizapp.controllers.UserOptions;
import com.bootcamp.quizapp.controllers.GameController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

    @Controller
//    @RequestMapping("templates")
    public class NewUser {

        private static String newUserName;
        private static String newUserEmail;
        private static String newUserPassword;


        // Should return values from the form in register.html
        // also gives back the data in url path variables, i.e.
        // http://localhost:8080/register?name=vardas&email=email%40gmail.com&password=aaaaaa
        //
        // Perhaps a controller to check the password requirements could be implemented here as well.

        @GetMapping("/register")
        public String getLoginDetails(){
//                (@RequestParam String name, @RequestParam String email, @RequestParam String password){
//            newUserName = name;
//            newUserEmail = email;
//            newUserPassword = password;
            // Avatars not included yet
            return "login";
        }
    }

