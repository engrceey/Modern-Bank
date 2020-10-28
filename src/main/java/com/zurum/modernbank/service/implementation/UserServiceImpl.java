package com.zurum.modernbank.service.implementation;

import com.zurum.modernbank.configuration.PasswordConfig;
import com.zurum.modernbank.dto.UserRegistrationDto;
import com.zurum.modernbank.entity.User;
import com.zurum.modernbank.repository.UserRepository;
import com.zurum.modernbank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordConfig passwordConfig;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(PasswordConfig passwordConfig, UserRepository userRepository) {
        this.passwordConfig = passwordConfig;
        this.userRepository = userRepository;
    }


    @Override
    public User registerUser(UserRegistrationDto userRegistrationDto) {
        User user = new User();
        user.setEmail(userRegistrationDto.getEmail());
        user.setFirstName(userRegistrationDto.getFirstName());
        user.setLastName(userRegistrationDto.getLastName());
        String password = userRegistrationDto.getPassword();
        String passwordTwo = userRegistrationDto.getRetypePassword();

        if(!password.equals(passwordTwo)) {
            throw new ValidationException("Password Mismatch");
        }

        user.setPassword(passwordConfig.encoder().encode(userRegistrationDto.getPassword()));
        user.setUsername(userRegistrationDto.getUsername());
        user.setDob(userRegistrationDto.getDob());


       return userRepository.save(user);

    }
}
