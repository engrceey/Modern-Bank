package com.zurum.modernbank.service;

import com.zurum.modernbank.dto.TransactionResponseDto;
import com.zurum.modernbank.entity.Transaction;

import java.math.BigDecimal;

public interface TransactionService {

        Transaction depositFund(Long id, Transaction transaction);
}
