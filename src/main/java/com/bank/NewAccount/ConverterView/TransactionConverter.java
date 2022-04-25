package com.bank.NewAccount.ConverterView;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.bank.NewAccount.Entity.Transaction;
import com.bank.NewAccount.view.TransactionView;

@Component
public class TransactionConverter implements Converter<Transaction, TransactionView> {

	@Override
	public TransactionView convert(Transaction source) {
		TransactionView view = new TransactionView();
		view.setAccount(source.getAccount());
		view.setAmount(source.getAmount());
		view.setDateTransaction(source.getDateTransaction());
		view.setId(source.getId());
		return view;
	}

}
