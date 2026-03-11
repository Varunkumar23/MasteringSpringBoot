package com.lpu.UserManagementSystem.config;

import org.hibernate.annotations.ConcreteProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
//this annotation tells that dont use default security configuration use the one that i have defined here
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//            http.csrf(customiser->customiser.disable()); // we are disabling the csrf token because there is no use of this when we are not using the session and cookies
//            http.authorizeHttpRequests(request->request.anyRequest().authenticated());
//            http.formLogin(Customizer.withDefaults());
//            http.httpBasic(Customizer.withDefaults());
//            http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        // instead of writing all the multiple lines of code like above we follow this builder pattern for buildeing the filter chain
        return http
                .csrf(customizer -> customizer.disable())
                .authorizeHttpRequests(request -> request.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();


    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
}
