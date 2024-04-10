package com.example.demo;


import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegController {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    @GetMapping
    public String registerForm(){
        return "registration";
    }

    @PostMapping
    public String processReg(RegForm form){
        userRepo.save(form.toUser(passwordEncoder));
        return "redirect:/login";
    }

}
