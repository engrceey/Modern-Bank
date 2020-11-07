package com.zurum.modernbank.controller;

import com.zurum.modernbank.dto.UserRegistrationDto;
import com.zurum.modernbank.dto.UserRequestDto;
import com.zurum.modernbank.dto.UserUpdateDto;
import com.zurum.modernbank.entity.User;
import com.zurum.modernbank.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("user/registration")
    @ApiOperation(value = "Register a new user",
            notes = "Register a user",
            response = User.class)
    public ResponseEntity<User> registerUser(@RequestBody @Valid UserRegistrationDto userRegistrationDto) throws Exception {
        User newUser = userService.registerUser(userRegistrationDto);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }


    @GetMapping("user/{id}")
    @ApiOperation(value = "Get a user by their id number",
            notes = "Get a user by their id number note",
            response = User.class)
    public ResponseEntity<UserRequestDto> getUserDetails(@PathVariable long id) {
        UserRequestDto userRequestDto = userService.getUserDetails(id);
        return new ResponseEntity<>(userRequestDto, HttpStatus.OK);
    }

   @PutMapping("update/user/{id}")
   @ApiOperation(value = "Updates users profile details",
           notes = "Update a users profile",
           response = User.class)
    public ResponseEntity<User> updateUserDetail(@PathVariable("id") long id,@RequestBody UserUpdateDto updateDto) {
        User userUpdateDto = userService.updateUser(id, updateDto);
        return new ResponseEntity<>(userUpdateDto,HttpStatus.OK);
   }

}
