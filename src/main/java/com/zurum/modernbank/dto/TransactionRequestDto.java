package com.zurum.modernbank.dto;

import com.zurum.modernbank.entity.Account;
import com.zurum.modernbank.entity.User;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionRequestDto {

    private long id;

    private BigDecimal amount;

    private LocalDateTime transactionTime;

    private String transactionType;

    private String status;

    private Account account;

    private User user;
}
