package com.bank.NewAccount.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.NewAccount.ConverterView.AccountConverter;
import com.bank.NewAccount.Entity.Account;
import com.bank.NewAccount.Entity.Costumer;
import com.bank.NewAccount.Repositories.AccountRepository;
import com.bank.NewAccount.error.EntityNotFoundException;
import com.bank.NewAccount.util.MessageUtil;
import com.bank.NewAccount.view.AccountView;

@Service
public class AccountService {
    private final AccountRepository accountRepo;
    private final AccountConverter accountConverter;
	private final MessageUtil messageUtil;
    public AccountService(AccountRepository accountRepo, AccountConverter accountConverter,MessageUtil messageUtil)
    {
    	this.accountRepo=accountRepo;
    	this.accountConverter = accountConverter;
    	this.messageUtil = messageUtil;
    }

    public Account addNewAccount(Account account) {
        return accountRepo.save(account);
    }
    
    public List<Account> getAllAccount()
    {
    	return accountRepo.findAll();
    }
    
    public List<Account> getAccountsByCostumerID(long costID)
    {
       List<Account> lstAccount = new ArrayList<>();
       this.accountRepo.findAll().stream().filter(acc -> acc.getCostumer().getId()==costID ).forEach(c -> lstAccount.add(c));
       return lstAccount;
    }
    
	public long addNewAccountToExistenCost(Costumer costumerExisting) {
        Account newAcc = new Account(0.0,costumerExisting);
		return this.accountRepo.save(newAcc).getId();
	}
	
	public AccountView convertToView(Account a)
	{
		return accountConverter.convert(a);
	}
	
    @Transactional
	public Account transaction(long idNewAcc, double initialCredit) {
     Account acc = this.accountRepo.findById(idNewAcc).orElseThrow(() -> new EntityNotFoundException(messageUtil.getMessage("Account.notFound", idNewAcc) ));
     acc.setAmount(initialCredit);
     return this.accountRepo.save(acc);
	}
	
}
