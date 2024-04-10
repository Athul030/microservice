package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){
        List<UserDetails> usersList = new ArrayList<>();

        usersList.add(new org.springframework.security.core.userdetails.User("buzz",passwordEncoder.encode("password"),
                Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));
        usersList.add(new org.springframework.security.core.userdetails.User("woody",passwordEncoder.encode("password"),
                Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));

        return new InMemoryUserDetailsManager(usersList);
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepo userRepo){
        return username ->{
            User user = userRepo.findByUsername(username);
            if(user!=null) return user;

            throw new UsernameNotFoundException("User "+username+" nof found");
        };
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
         http
                .authorizeHttpRequests(authorize->authorize
                        .requestMatchers("/design","/orders").hasRole("USER")
                        .requestMatchers("/","/**").permitAll()
                );

                return http.build();

    }


}
