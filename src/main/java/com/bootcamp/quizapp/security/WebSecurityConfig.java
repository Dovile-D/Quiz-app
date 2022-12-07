package com.bootcamp.quizapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;

import static org.springframework.security.config.Customizer.withDefaults;

//////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////
//
//      !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//
//      TRYING TO ALLOW ACCESS TO ALL FILES, SINCE I'M GETTING
//      ERRORS 403: FORBIDDEN WHEN I TRY TO ACCESS DIFFERENT PAGES
//      SEEMS TO BE WORKING FOR THE MOMENT
//
//      TO BE REMOVED ONCE SPRING SECURITY IS CONFIGURED
//
//////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////

@Configuration
@EnableWebSecurity
public class WebSecurityConfig  {


    @Configuration
    public class ApplicationNoSecurity {

        @Bean
        public WebSecurityCustomizer webSecurityCustomizer() {
            return (web) -> web.ignoring()
                    .requestMatchers("/**");
        }
    }
//
//
//
//    @Bean
//    SecurityFilterChain web(HttpSecurity http) throws Exception {
//        http
//                // ...
//                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers("/**","/resources/**", "*/*").permitAll()
////                        .requestMatchers("/admin/**").hasRole("ADMIN")
////                        .requestMatchers("/db/**").access(new WebExpressionAuthorizationManager("hasRole('ADMIN') and hasRole('DBA')"))
////                        .anyRequest().denyAll()
//                );
//
//        return http.build();
//    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//        http
//                .authorizeHttpRequests((authz) -> authz
//                .anyRequest().authenticated()
//        )
//
//                .authorizeHttpRequests().requestMatchers("/**").permitAll().anyRequest();
////                .authorizeHttpRequests().requestMatchers("/**").permitAll().anyRequest()
////                .and()
//                .httpBasic(withDefaults());
//        return http.build();
//
//    }

}