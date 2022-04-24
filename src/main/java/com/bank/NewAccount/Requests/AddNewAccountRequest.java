package com.bank.NewAccount.Requests;

public class AddNewAccountRequest {
	private double initialCredit;

	public AddNewAccountRequest(double initialCredit) {
		super();
		this.initialCredit = initialCredit;
	}

	public AddNewAccountRequest() {
		super();
	}


	public double getInitialCredit() {
		return initialCredit;
	}

	public void setInitialCredit(double initialCredit) {
		this.initialCredit = initialCredit;
	}

}
