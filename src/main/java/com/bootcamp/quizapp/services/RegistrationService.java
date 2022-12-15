package com.bootcamp.quizapp.services;

import com.bootcamp.quizapp.dto.RegistrationRequestDto;
import com.bootcamp.quizapp.models.User;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {
    private UserDetailsService customUserDetailsService;
    private EmailValidator emailValidator;

    public User register(String name, String email, String password) {
        boolean isValid = emailValidator
                .test(email);
        if (!isValid) {
            throw new IllegalStateException("This email not valid");
        }
        return  customUserDetailsService.signUpUser(
                new User(
                        name,
                        email,
                        password)
                );
    }
}
