package com.Banking.Banking_app.service.impl;

import com.Banking.Banking_app.entity.Account;
import com.Banking.Banking_app.repository.AccountRepository;
import com.Banking.Banking_app.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class Accountserviceimpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;


    @Override
    public Account addAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account getAccountById(Long id) {
        Optional<Account> account = accountRepository.findById(id);
        return account.orElse(null);
    }

    @Override
    public List<Account> getAllAccounts() {
        return (List<Account>) accountRepository.findAll();
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public Account updateAccount(Long id, Account account) {
        if (accountRepository.existsById(id)) {
            account.setId(id);
            return accountRepository.save(account);
        }
        return null;
    }
}

