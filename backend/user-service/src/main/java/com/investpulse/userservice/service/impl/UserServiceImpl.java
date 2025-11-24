package com.investpulse.userservice.service.impl;

import com.investpulse.userservice.dto.UserDto;
import com.investpulse.userservice.model.User;
import com.investpulse.userservice.repository.UserRepository;
import com.investpulse.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User register(UserDto userDto) {
        if(userRepository.existsByEmail(userDto.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        User user = User.builder()
                .fullName(userDto.getFullName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .build();

        return  userRepository.save(user);
    }
}
