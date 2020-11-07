package com.zurum.modernbank.service;

import com.zurum.modernbank.entity.Account;

public interface AccountService {
    Account getAccountStatement(long id);

    Account createAccount();
}
