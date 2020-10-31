package com.zurum.modernbank.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Lob;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateDto {

    private String username;

    private String firstName;

    private String lastName;

    @Lob
    @Size(min = 5)
    private String password;

    @Lob
    @Size(min = 5)
    private String confirmPassword;

}
