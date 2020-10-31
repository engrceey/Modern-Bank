package com.zurum.modernbank.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long accountId;

    private String accountType;

    private Integer accountNumber;

    private BigDecimal accountBalance;

    @OneToOne
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Transaction> transactions;
}
