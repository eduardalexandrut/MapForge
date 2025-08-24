package com.example.mapforge.service;

import com.example.mapforge.model.User;
import com.example.mapforge.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder,
                       JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

//    public User signUp(User user) {
//        //check if there is already a user with the same email
//        //set password encripted and save
//    }
//
//    public String signIn(String email, String password) {
//
//    }
}
