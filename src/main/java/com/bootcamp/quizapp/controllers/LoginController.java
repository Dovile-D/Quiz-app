package com.bootcamp.quizapp.controllers;


import com.bootcamp.quizapp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
public class LoginController {

private final UserRepository userRepository;
    BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();


    @GetMapping("/login")  // OK
    public ModelAndView showLogin(ModelMap model){

        return new ModelAndView("login.html", model); }



    @GetMapping(value = "/userOptions")
public ModelAndView checkUserLogin(ModelMap model, @RequestParam(name = "email") String urlEmail,
                                   @RequestParam(name = "password") String urlPassword) {

        ModelAndView returnedPage = null;

//        checking if provided email is in DB


// checking if the password matches encrypted password
        if(userRepository.existsUserByEmail(urlEmail) &&
                bcrypt.matches(urlPassword, userRepository.getUserByEmail(urlEmail).getPassword())) {
            returnedPage = new ModelAndView("user_option.html", model);
        }
        else {
            returnedPage = new ModelAndView("login.html", model);
        }

        return returnedPage;

    }


}