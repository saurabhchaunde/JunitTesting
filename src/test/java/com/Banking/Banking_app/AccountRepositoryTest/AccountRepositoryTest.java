package com.Banking.Banking_app.AccountRepositoryTest;

import com.Banking.Banking_app.entity.Account;
import com.Banking.Banking_app.repository.AccountRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class AccountRepositoryTest {
    @Autowired
    private AccountRepository accountRepository;

    @Test

    void getAccountByName() {
        Account account = new Account(123L, "shivraj mama", 850000.0); // Ensure balance is a Double
        accountRepository.save(account);
        List<Account> resultAccounts = accountRepository.getAccountsByName("shivraj mama"); // Use the updated method
        assertNotNull(resultAccounts);
        assertEquals(account.getAccountHolderName(), resultAccounts.get(0).getAccountHolderName());
        assertEquals(account.getBalance(), resultAccounts.get(0).getBalance());

        System.out.println(resultAccounts.toString());
    }

    @Test
    void testGetAccountById() {
        Account account=new Account(93L,"saurabhchaunde",99000.00);
        accountRepository.save(account);
        List<Account> resultaccount=accountRepository.getAccountById(93L);
        assertFalse(resultaccount.isEmpty());
        assertEquals(account.getAccountHolderName(), resultaccount.get(0).getAccountHolderName());
        assertEquals(account.getBalance(), resultaccount.get(0).getBalance());
    }

    @Test
    void existsById() {
        Account account=new Account(120L,"shyam manav",19500.00);
        accountRepository.save(account);
        boolean result=accountRepository.existsById(120L);
        assertThat(result).isTrue();
    }

    @BeforeEach
    void setUp() { System.out.println("Setting up");}

    @AfterEach
    void tearDown() {
        System.out.println("tearingdown");
    }
}