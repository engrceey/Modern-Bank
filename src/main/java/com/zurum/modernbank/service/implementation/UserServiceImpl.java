package com.zurum.modernbank.service.implementation;

import com.zurum.modernbank.dto.UserRegistrationDto;
import com.zurum.modernbank.dto.UserRequestDto;
import com.zurum.modernbank.entity.User;
import com.zurum.modernbank.exception.ApiRequestException;
import com.zurum.modernbank.exception.UserNotFoundException;
import com.zurum.modernbank.repository.UserRepository;
import com.zurum.modernbank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder encoder;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(PasswordEncoder encoder, UserRepository userRepository) {
        this.encoder = encoder;
        this.userRepository = userRepository;
    }


    @Override
    public User registerUser(UserRegistrationDto userRegistrationDto){
        User user = new User();

        Optional<User> checkMail = userRepository.findUserByEmail(userRegistrationDto.getEmail());
        if(checkMail.isPresent()) {
            throw new ApiRequestException("Email already in use");
        }

        user.setEmail(userRegistrationDto.getEmail());
        user.setFirstName(userRegistrationDto.getFirstName());
        user.setLastName(userRegistrationDto.getLastName());
        String password = userRegistrationDto.getPassword();
        String passwordTwo = userRegistrationDto.getRetypePassword();

        if(!password.equals(passwordTwo)) {
            throw new ApiRequestException("Password Mismatch");
        }

        user.setPassword(encoder.encode(userRegistrationDto.getPassword()));
        user.setUsername(userRegistrationDto.getUsername());
        user.setDob(userRegistrationDto.getDob());

       return userRepository.save(user);

    }

    @Override
    public UserRequestDto getUserDetails(long id) {

        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty()) {
            throw new UserNotFoundException("User with id "+id+" not found");
        }

        UserRequestDto userRequestDto = new UserRequestDto();
        userRequestDto.setId(user.get().getUser_id());
        userRequestDto.setDob(user.get().getDob());
        userRequestDto.setEmail(user.get().getEmail());
        userRequestDto.setFirstName(user.get().getFirstName());
        userRequestDto.setLastName(user.get().getLastName());
        userRequestDto.setUsername(user.get().getUsername());

        return userRequestDto;
    }
}
