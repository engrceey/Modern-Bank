package com.zurum.modernbank.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@ApiModel(description = "this is the users entity")
public class User  {

    @Id
    @ApiModelProperty(value = "the unique id of the users")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long user_id;

    @NotBlank
    @ApiModelProperty(value = "the users name")
    @Column(unique = true, nullable = false)
    private String username;

    @NotBlank
    @ApiModelProperty(value = "this is users firstname")
    private String firstName;

    @NotBlank
    @ApiModelProperty(value = "this is users lastname")
    private String lastName;

    @Lob
    @NotBlank
    @Size(min = 5)
    @ApiModelProperty(value = "encoded password")
    private String password;

    @NotBlank

    @Email
    @Column(unique = true, updatable = false, nullable = false)
    @ApiModelProperty(value = "unique")
    private String email;

    @UpdateTimestamp
    private LocalDateTime timeStamp;

    @CreationTimestamp
    private LocalDateTime createdDate;

    @Past
    @JsonFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "Users Date of birth")
    private Date dob;

    @OneToOne( cascade = CascadeType.ALL)
    private Account account;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Transaction> transactions;

}
