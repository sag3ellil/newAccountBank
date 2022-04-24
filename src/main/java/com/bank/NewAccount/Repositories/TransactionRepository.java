package com.bank.NewAccount.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.NewAccount.Entity.Transaction;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
