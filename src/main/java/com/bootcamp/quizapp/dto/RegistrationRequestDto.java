package com.bootcamp.quizapp.dto;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class RegistrationRequestDto {
    private final String username;
    private final String email;
    private final String password;
    private String avatar;

}
