package com.investpulse.userservice.service;

import com.investpulse.userservice.dto.UserDto;
import com.investpulse.userservice.model.User;

public interface UserService {
    User registerUser(UserDto userDto);
    User login(String email, String password);
}
