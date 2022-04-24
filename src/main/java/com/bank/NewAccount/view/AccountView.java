package com.bank.NewAccount.view;

import com.bank.NewAccount.Entity.Costumer;

public class AccountView {
    private long accountId;
	
	private Double amount;
	
    private Costumer costumer;

	public AccountView(long accountId, Double amount, Costumer costumer) {
		super();
		this.accountId = accountId;
		this.amount = amount;
		this.costumer = costumer;
	}

	public AccountView() {
		super();
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Costumer getCostumer() {
		return costumer;
	}

	public void setCostumer(Costumer costumer) {
		this.costumer = costumer;
	}
    
}
