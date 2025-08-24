package com.example.mapforge.controller;

import com.example.mapforge.model.User;
import com.example.mapforge.repository.UserRepository;
import com.example.mapforge.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController  {

    private final UserService userService;

    public AuthenticationController(final UserService userService) {
        this.userService = userService;
    }

    // POST /api/v1/auth/signin -> signin using email and password, and get a jwt token
    @PostMapping("/signin")
    public ResponseEntity signin(@RequestBody Map<String, String> credentials) {
        String token = userService.signIn(credentials.get("eamil"), credentials.get("password"));
        return ResponseEntity.ok(token);
    }

    // POST /api/v1/auth/signup
    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody User user) {
        return ResponseEntity.ok(userService.signUp(user));
    }
}
