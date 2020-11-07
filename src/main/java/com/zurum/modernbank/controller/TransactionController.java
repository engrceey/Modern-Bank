package com.zurum.modernbank.controller;

import com.zurum.modernbank.entity.Transaction;
import com.zurum.modernbank.entity.User;
import com.zurum.modernbank.service.TransactionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PutMapping("user/transaction/deposit/{id}")
    @ApiOperation(value = "Deposite money to account",
            notes = "Deposite money to account",
            response = Transaction.class)
    public ResponseEntity<Transaction> depositFund(@PathVariable long id,
                                                              @RequestBody Transaction transaction) {
        Transaction newTransaction = transactionService.depositFund(id, transaction);
        return new ResponseEntity<>(newTransaction, HttpStatus.OK);

    }

}
