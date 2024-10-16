package com.Banking.Banking_app.repository;

import com.Banking.Banking_app.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query("SELECT a FROM Account a WHERE a.accountHolderName = :accountHolderName")
    List<Account> getAccountsByName(@Param("accountHolderName") String accountHolderName);



    @Query("SELECT a FROM Account a WHERE a.id = :id")
    List<Account> getAccountById(Long id);

    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN TRUE ELSE FALSE END FROM Account a WHERE a.id = :id")
    boolean existsById(@Param("id") Long id);

}
