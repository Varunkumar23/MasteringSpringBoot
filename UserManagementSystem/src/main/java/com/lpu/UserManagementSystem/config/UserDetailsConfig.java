package com.lpu.UserManagementSystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserDetailsConfig {

    // in this class we are creating a custom UserDetailsService as a bean because we want to test with the help of
    // in memory username and password
//    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user1= User.withDefaultPasswordEncoder()
                .username("Varun")
                .password("1234")
                .roles("USER").build();

        return new InMemoryUserDetailsManager(user1);
    }
}
