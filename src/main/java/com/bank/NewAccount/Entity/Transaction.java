package com.bank.NewAccount.Entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Transaction")
public class Transaction {
	@Id
	@GeneratedValue
	@Column(name = "transaction_id")
	private long id;


	@NonNull
	private Double amount;

	@NonNull
	private Date dateTransaction;

	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "account_id", referencedColumnName = "account_id")
	//@JsonIgnoreProperties("transactions")
    private Account account;


	public Transaction(@NonNull Double amount, @NonNull Date dateTransaction, Account account) {
		super();
		this.amount = amount;
		this.dateTransaction = dateTransaction;
		this.account = account;
	}


	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
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


	public Date getDateTransaction() {
		return dateTransaction;
	}


	public void setDateTransaction(Date dateTransaction) {
		this.dateTransaction = dateTransaction;
	}


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}

	
	
}
