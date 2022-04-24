package com.bank.NewAccount.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transaction {
	@Id
	@GeneratedValue
	@Column(name = "transaction_id")
	private long id;


	@NonNull
	private Double amount;

	@NonNull
	private Date dateTransaction;

	
	@OneToOne
    @JoinColumn(name="account_id", nullable=false)
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
