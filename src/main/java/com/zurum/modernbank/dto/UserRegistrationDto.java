package com.zurum.modernbank.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class UserRegistrationDto {

    private String username;

    private String firstName;

    private String lastName;

    private String password;

    private String retypePassword;

    private String email;

    private Date dob;


}
