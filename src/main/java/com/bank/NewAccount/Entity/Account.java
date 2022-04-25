package com.bank.NewAccount.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Account")
public class Account {
	@Id
	@GeneratedValue
	@Column(name="account_id")
	private long accountId;
	
	@Column(name="amount")
	private Double amount;
	

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "costumer_id", referencedColumnName = "costumer_id")
    @JsonIgnoreProperties("accounts")
    private Costumer costumer;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "account", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("account")
    private List<Transaction> transactions = new ArrayList<>();

	
	public Account(Double amount, Costumer costumer) {
		super();
		this.amount = amount;
		this.costumer = costumer;
	}
	
	public Costumer getCostumer() {
		return costumer;
	}

	public void setCostumer(Costumer costumer) {
		this.costumer = costumer;
	}

	
	
	public Account() {
		super();
	}

	public long getId() {
		return accountId;
	}
	public void setId(long id) {
		this.accountId = id;
	}

	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	
	
}
