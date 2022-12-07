package com.bootcamp.quizapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserLogin {

    private static String loginEmail;
    private static String loginPassword;

        // on button click user credentials are stored locally in loginName and loginPassword and
        // user is redirected to user_option page
        // a boolean method to check the credentials should be added
        // then the user will be redirected only if the credentials are valid

        // User credentials are also visible in the url query variables, i.e.:
        // http://localhost:8080/userOptions?email=12%4012.li&password=123
        @GetMapping("/userOptions")
        public String getLoginDetails(@RequestParam String email, @RequestParam String password){
            loginEmail = email;
            loginPassword = password;
            return ("user_option.html");
        }

        //Access to registration page is transformed into a form

    @GetMapping("/goRegister")
    public String newUserRegistration(){
        return ("register.html");
    }
    }

