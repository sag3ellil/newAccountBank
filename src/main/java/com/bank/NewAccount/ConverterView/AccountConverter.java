package com.bank.NewAccount.ConverterView;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.bank.NewAccount.Entity.Account;
import com.bank.NewAccount.view.AccountView;

@Component
public class AccountConverter implements Converter<Account, AccountView> {

	@Override
	public AccountView convert(Account source) {
		AccountView view = new AccountView();
		view.setAccountId(source.getId());
		view.setAmount(source.getAmount());
		view.setCostumer(source.getCostumer());
		return view;
	}

	

}
