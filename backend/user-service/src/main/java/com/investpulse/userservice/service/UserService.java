package com.investpulse.userservice.service;

import com.investpulse.userservice.dto.UserDto;
import com.investpulse.userservice.model.User;

public interface UserService {
    User register(UserDto userDto);
}
