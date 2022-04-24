package com.bank.NewAccount.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.NewAccount.Entity.Costumer;
@Repository
public interface CostumerRepository extends JpaRepository<Costumer, Long>  {

}
