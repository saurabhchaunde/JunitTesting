package com.Banking.Banking_app.service;

import com.Banking.Banking_app.entity.Account;



import java.util.List;

public interface AccountService {
    Account addAccount(Account account);
    Account getAccountById(Long id);
    List<Account> getAllAccounts();
    void deleteAccount(Long id);
    Account updateAccount(Long id, Account account);
}

