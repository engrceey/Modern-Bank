package com.zurum.modernbank.service;

import com.zurum.modernbank.dto.UserRegistrationDto;
import com.zurum.modernbank.dto.UserRequestDto;
import com.zurum.modernbank.dto.UserUpdateDto;
import com.zurum.modernbank.entity.User;

public interface UserService {
    User registerUser(UserRegistrationDto userRegistrationDto) throws Exception;

    UserRequestDto getUserDetails(long id);

    UserRequestDto getAccountStatement(long id);

    User updateUser(long id, UserUpdateDto userUpdate);
}
