package com.bank.NewAccount.ConverterView;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.bank.NewAccount.Entity.Costumer;
import com.bank.NewAccount.view.CostumerView;

@Component
public class CostumerConverter implements Converter<Costumer, CostumerView> {

	@Override
	public CostumerView convert(Costumer costumer) {
		CostumerView view = new CostumerView();
		view.setAccounts(costumer.getAccounts());
		view.setCostumerID(costumer.getId());
		view.setName(costumer.getName());
		view.setSurname(costumer.getSurname());
		return view;
	}

}
