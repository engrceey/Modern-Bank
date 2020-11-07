package com.zurum.modernbank.service.implementation;

import com.zurum.modernbank.entity.Account;
import com.zurum.modernbank.entity.Transaction;
import com.zurum.modernbank.entity.User;
import com.zurum.modernbank.exception.ApiRequestException;
import com.zurum.modernbank.repository.AccountRepository;
import com.zurum.modernbank.repository.TransactionRepository;
import com.zurum.modernbank.repository.UserRepository;
import com.zurum.modernbank.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private final TransactionRepository transactionRepository;

    @Autowired
    private final AccountRepository accountRepository;

    @Autowired
    private final UserRepository userRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository,
                                  AccountRepository accountRepository,
                                  UserRepository userRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Transaction depositFund(Long id, Transaction transaction) {

        System.out.println("hi1");
        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty()){
            throw new ApiRequestException("user with id: "+id+" not found");
        }

        System.out.println("hio");
        BigDecimal usersAccountBalance =  user.get().getAccount().getAccountBalance();
//        if(usersAccountBalance.equals(null)) {
//            usersAccountBalance = ;
//        }

        Account account = accountRepository.getOne(id);
        account.setAccountBalance(usersAccountBalance);
        account.setUser(user.get());

        System.out.println("hi2");
        accountRepository.save(account);

        System.out.println("hi3");
        BigDecimal depositFund = usersAccountBalance.add(transaction.getAmount());
        Transaction newtransaction = new Transaction();
        newtransaction.setAmount(depositFund);
        newtransaction.setStatus("deposit "+transaction.getAmount()+" was successful");
        newtransaction.setUser(user.get());
        newtransaction.setAccount(account);
        newtransaction.setTransactionType("Deposit");

        System.out.println("hi4");
        return transactionRepository.save(newtransaction);

    }
}
