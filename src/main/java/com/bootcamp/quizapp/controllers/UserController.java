package com.bootcamp.quizapp.controllers;

import com.bootcamp.quizapp.services.UserDetailsService;
import com.bootcamp.quizapp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import com.bootcamp.quizapp.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {

        private final UserDetailsService customUserDetailsService;
        private final UserRepository userRepository;

        //user login
        @GetMapping("/login")
        public String getUser(){
            return "Welcome, let's have a fun quiz!";
        }

        //get list of all users
        @GetMapping(value = "/users")
        public List<User> getUsers() {
            return userRepository.findAll();
        }

//        //get user by User id
//        @GetMapping("/users/{id}")
//        public User getUser(@PathVariable int id) {
//            return userRepository.findById(id).orElseThrow(RuntimeException::new);
//        }


//    @GetMapping("/registered")
//    public String showloginOnRegister(){return "login"; }
//
//
//    @GetMapping("/registerNew")
//    public String newUserRegistration(){return ("register"); }

}
