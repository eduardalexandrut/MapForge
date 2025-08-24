package com.example.mapforge.controller;

import com.example.mapforge.repository.UserRepository;
import com.example.mapforge.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController  {

    private final UserService userService;

    public AuthenticationController(final UserService userService) {
        this.userService = userService;
    }

    // POST /api/v1/auth/signin -> signin using email and password, and get a jwt token
    // POST /api/v1/auth/signup

}
