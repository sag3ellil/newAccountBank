package com.bank.NewAccount.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "costumer")
public class Costumer {
	@Id
	@GeneratedValue
	@Column(name = "costumer_id")
	private long costumerId;

	@NonNull
	@Column(name = "name")
	private String name;

	@NonNull
	@Column(name = "surname")
	private String surname;

	@NonNull
	@Column(name = "balance")
	private Double balance;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "costumer", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("costumer")
    private List<Account> accounts = new ArrayList<>();


	public Costumer(@NonNull String name, @NonNull String surname, @NonNull double balance) {
		super();
		this.name = name;
		this.surname = surname;
		this.balance=balance;
	}
	
	
    
	public long getCostumerId() {
		return costumerId;
	}



	public void setCostumerId(long costumerId) {
		this.costumerId = costumerId;
	}



	public Double getBalance() {
		return balance;
	}



	public void setBalance(Double balance) {
		this.balance = balance;
	}



	public Costumer() {
		super();
	}
	
	
	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public long getId() {
		return costumerId;
	}

	public void setId(long id) {
		this.costumerId = id;
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

}
