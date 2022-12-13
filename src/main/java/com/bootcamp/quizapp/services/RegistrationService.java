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

    public String register(RegistrationRequestDto request) {
        boolean isValid = emailValidator
                .test(request.getEmail());
        if (!isValid) {
            throw new IllegalStateException("This email not valid");
        }
        return  customUserDetailsService.signUpUser(
                new User(
                        request.getUsername(),
                        request.getEmail(),
                        request.getPassword(),
                        request.getAvatar()
                )
        );
    }
}
