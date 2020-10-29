package com.zurum.modernbank.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Past;
import java.util.Date;

@Data
@NoArgsConstructor
public class UserRequestDto {

    private long id;

    private String username;

    private String firstName;

    private String lastName;

    private String email;

    @Past
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dob;

}
