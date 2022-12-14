package com.bootcamp.quizapp.services;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    //    method to convert category email values from url to values in DB
    public String getProperEmail(String emailFromUrl) {

        String convertedEmail = emailFromUrl.replace("%40", "@");

        return convertedEmail;
    }
}
