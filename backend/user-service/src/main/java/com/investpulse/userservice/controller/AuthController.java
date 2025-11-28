package com.investpulse.userservice.controller;

import com.investpulse.userservice.dto.LoginRequest;
import com.investpulse.userservice.dto.LoginResponse;
import com.investpulse.userservice.model.User;
import com.investpulse.userservice.repository.UserRepository;
import com.investpulse.userservice.security.JwtService;
import com.investpulse.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            User user = userService.login(request.getEmail(), request.getPassword());
            String token = jwtService.generateToken(user.getEmail());
            return ResponseEntity.ok(new LoginResponse(token));
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
        /*User dbUser = userRepository.findByEmail(request.getEmail())
                .orElse(null);

        if(dbUser == null) {
            return ResponseEntity.status(404).body("User not found");
        }
        if(!passwordEncoder.matches(request.getPassword(), dbUser.getPassword())){
            return ResponseEntity.status(401).body("Invalid Password");
        }
        String token = jwtService.generateToken(dbUser.getEmail());
        return ResponseEntity.ok(token);*/
    }
}
