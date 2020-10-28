package com.zurum.modernbank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UserRequestDto {

    private long id;

    private String username;

    private String firstName;

    private String lastName;

    private String email;

    @Past
    private LocalDate dob;

}
