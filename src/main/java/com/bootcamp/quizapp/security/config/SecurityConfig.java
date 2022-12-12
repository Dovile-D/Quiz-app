//package com.bootcamp.quizapp.security.config;
//
//import lombok.AllArgsConstructor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//
//    @Configuration
//    @AllArgsConstructor
//    @EnableWebSecurity
//    public class SecurityConfig {
//        private final UserDetailsService userDetailsService;
//        private final BCryptPasswordEncoder bCryptPasswordEncoder;
//
//        @Bean
//        public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
//            http
//                    .csrf().disable()
//                    .authorizeHttpRequests()
//                    .requestMatchers("/", "api/v1/registration")
//                    .permitAll()///???? What we will discuss to permit
//                    .requestMatchers ("/registration").hasAuthority("USER")
//                    .requestMatchers("/admin").hasRole("ADMIN")
//                    .requestMatchers( "api/v1/updateUser/**")
//                    .permitAll()///???? What we will discuss to permit
//                    .anyRequest()
//                    .authenticated()
//                    .and()
//                    .sessionManagement()
//                    .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
//                    .and()
//                    .authenticationProvider(authenticationProvider())
//                    .httpBasic();
//
//            return http.build();
//        }
//        @Bean
//        AuthenticationProvider authenticationProvider() {
//            DaoAuthenticationProvider provider
//                    = new DaoAuthenticationProvider();
//            provider.setUserDetailsService(userDetailsService);
//            provider.setPasswordEncoder(bCryptPasswordEncoder);
//            return  provider;
//        }
//
//        @Bean
//        public AuthenticationManager authenticationManager (AuthenticationConfiguration configuration) throws Exception{
//            return configuration.getAuthenticationManager();
//        }
//
//
//    }
