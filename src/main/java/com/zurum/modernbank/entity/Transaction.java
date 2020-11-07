package com.zurum.modernbank.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    private BigDecimal amount;

    @UpdateTimestamp
    private LocalDateTime transactionTime;

    private String transactionType;

    private String status;

//
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account")
    private Account account;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
}
