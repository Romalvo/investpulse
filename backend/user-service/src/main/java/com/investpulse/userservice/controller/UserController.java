package com.investpulse.userservice.controller;

import com.investpulse.userservice.dto.UserDto;
import com.investpulse.userservice.model.User;
import com.investpulse.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.register(userDto));
    }
}
