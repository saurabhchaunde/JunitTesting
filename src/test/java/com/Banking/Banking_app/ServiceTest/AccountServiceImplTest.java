package com.Banking.Banking_app.ServiceTest;

import com.Banking.Banking_app.entity.Account;
import com.Banking.Banking_app.repository.AccountRepository;
import com.Banking.Banking_app.service.impl.Accountserviceimpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AccountServiceImplTest {

    @Mock
    private AccountRepository accountRepository;
    @InjectMocks
    private Accountserviceimpl accountService; // Change this to AccountServiceImpl


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    @Test
    void testGetAccountById() {
        Long accountId = 90L;
        Account account = new Account(accountId, "shivamvarmaa", 2000.0);
        accountRepository.save(account);
        when(accountRepository.findById(accountId)).thenReturn(Optional.of(account));
        Account result = accountService.getAccountById(accountId);
        assertNotNull(result);
        assertEquals(accountId, result.getId());
        assertEquals("shivamvarmaa", result.getAccountHolderName());
        assertEquals(2000.0, result.getBalance());

         verify(accountRepository).findById(accountId);
    }


    @Test
     void testGetAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account(1L, "Account1", 1000.0));
        accounts.add(new Account(2L, "Account2", 2000.0));

        when(accountRepository.findAll()).thenReturn(accounts);

        List<Account> result = accountService.getAllAccounts();

        assertEquals(2, result.size());
        verify(accountRepository).findAll();
        // Verify interaction
//        List<Account> list1= (List<Account>) accountRepository.findAll();
//        List<Account> list2=accountService.getAllAccounts();
//        System.out.println(list2.size());
//        System.out.println(list1.size());
//        assertEquals(list1.size(),list2.size());
//
//        accountService.getAllAccounts();
//        verify(accountRepository).findAll();
    }

    @Test
    void testAddAccount() {
        Account account = new Account(90L, "shivamvarmaa", 2000.0);

        when(accountRepository.save(account)).thenReturn(account);

        Account result = accountService.addAccount(account);

        assertNotNull(result);
        assertEquals("shivamvarmaa", result.getAccountHolderName());
        verify(accountRepository).save(account);
    }

    @Test
    void testDeleteAccount() {
        Long accountId = 90L;
        accountService.deleteAccount(accountId);
        verify(accountRepository).deleteById(accountId);
    }
}
