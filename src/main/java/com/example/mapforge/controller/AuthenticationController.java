package com.example.mapforge.controller;

import com.example.mapforge.model.dto.AuthResponseDTO;
import com.example.mapforge.model.entity.User;
import com.example.mapforge.service.UserService;
import org.springframework.http.ResponseEntity;
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
        AuthResponseDTO res = userService.signIn(credentials.get("email"), credentials.get("password"));

        if (!res.isSuccess()) {
            return ResponseEntity.badRequest().body(res.getMessage());
        }
        return ResponseEntity.ok(res.getToken());
    }

    // POST /api/v1/auth/signup
    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody User user) {
        AuthResponseDTO res = userService.signUp(user);

        if (!res.isSuccess()) {
            return ResponseEntity.badRequest().body(res.getMessage());
        }
        return ResponseEntity.ok(res.getUser());
    }
}
