package com.bank.NewAccount.view;

import java.util.Date;

import com.bank.NewAccount.Entity.Account;

public class TransactionView {
	private long id;

	private Double amount;

	private String dateTransaction;

	private Account account;

	public TransactionView() {
		super();
	}

	public TransactionView(long id, Double amount, String dateTransaction, Account account) {
		super();
		this.id = id;
		this.amount = amount;
		this.dateTransaction = dateTransaction;
		this.account = account;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDateTransaction() {
		return dateTransaction;
	}

	public void setDateTransaction(String dateTransaction) {
		this.dateTransaction = dateTransaction;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
