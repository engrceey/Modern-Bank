package com.zurum.modernbank.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.internal.build.AllowPrintStacktrace;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;


import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
@Table(name = "user")
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String username;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    @Size(min = 5, max = 15)
    private String password;

    @NotBlank
    @Email
    private String email;

    @UpdateTimestamp
    private LocalDateTime timeStamp;

    @CreationTimestamp
    private LocalDateTime createdDate;

    @Past
    private LocalDate dob;

    @OneToOne(cascade = CascadeType.ALL)
    private Account account;
}
