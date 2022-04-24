package com.bank.NewAccount.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.NewAccount.Entity.Account;
@Repository
public interface AccountRepository extends JpaRepository<Account, Long>  {

}
