package com.zurum.modernbank.service;

import com.zurum.modernbank.dto.UserRegistrationDto;
import com.zurum.modernbank.dto.UserRequestDto;
import com.zurum.modernbank.dto.UserResponseDto;
import com.zurum.modernbank.entity.User;
import org.springframework.stereotype.Service;

public interface UserService {
    User registerUser(UserRegistrationDto userRegistrationDto) throws Exception;

    UserRequestDto getUserDetails(long id);
}
