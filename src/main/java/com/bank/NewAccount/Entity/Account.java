package com.bank.NewAccount.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="Account")
public class Account {
	@Id
	@GeneratedValue
	@Column(name="account_id")
	private long accountId;
	
	@Column(name="amount")
	private Double amount;
	
	@OneToOne
    @JoinColumn(name="costumer_id", nullable=false)
    private Costumer costumer;
	
	@OneToMany(cascade = CascadeType.ALL)
    private Set<Transaction> transaction;

	
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
