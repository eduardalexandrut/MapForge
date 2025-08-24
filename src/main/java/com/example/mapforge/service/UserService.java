package com.example.mapforge.service;

import com.example.mapforge.model.dto.AuthResponseDTO;
import com.example.mapforge.model.entity.User;
import com.example.mapforge.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public AuthResponseDTO signUp(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return new AuthResponseDTO(false, "User already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);
        return new AuthResponseDTO(true, "User saved successfully", savedUser);
    }

    public AuthResponseDTO signIn(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);

        if (user.isEmpty()) {
            return new AuthResponseDTO(false, "User not found");
        }

        if (!passwordEncoder.matches(password, user.get().getPassword())) {
            return new AuthResponseDTO(false, "Incorrect password");
        }

        String token = jwtService.generateToken(user.get());
        return new AuthResponseDTO(true, "User signed in successfully", token);
    }
}
