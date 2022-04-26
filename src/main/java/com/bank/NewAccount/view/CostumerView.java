package com.bank.NewAccount.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.bank.NewAccount.Entity.Account;

public class CostumerView {
	private long costumerID;

	private String name;

	private String surname;

	private double balance;

	private List<Account> accounts = new ArrayList<>();

	public CostumerView(long costumerID, String name, String surname, List<Account> accounts, double balance) {
		super();
		this.costumerID = costumerID;
		this.name = name;
		this.surname = surname;
		this.accounts = accounts;
		this.balance = balance;
	}

	public CostumerView() {
		super();
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public long getCostumerID() {
		return costumerID;
	}

	public void setCostumerID(long costumerID) {
		this.costumerID = costumerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

}
