package com.zurum.modernbank.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long user_id;

    @NotBlank
    @Column(unique = true)
    private String username;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Lob
    @NotBlank
    @Size(min = 5)
    private String password;

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @UpdateTimestamp
    private LocalDateTime timeStamp;

    @CreationTimestamp
    private LocalDateTime createdDate;

    @Past
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dob;

    @OneToOne( cascade = CascadeType.ALL)
    private Account account;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Transaction> transactions;

}
