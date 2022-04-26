package com.bank.NewAccount.Services;

import org.springframework.stereotype.Service;

import com.bank.NewAccount.ConverterView.CostumerConverter;
import com.bank.NewAccount.Entity.Costumer;
import com.bank.NewAccount.Repositories.CostumerRepository;
import com.bank.NewAccount.error.EntityNotFoundException;
import com.bank.NewAccount.util.MessageUtil;
import com.bank.NewAccount.view.CostumerView;

@Service
public class CostumerService {

	private final CostumerRepository costumerRepo;
	private final MessageUtil messageUtil;
	private final CostumerConverter costumerConverter;

	public CostumerService(CostumerRepository costumerRepo, MessageUtil messageUtil,CostumerConverter costumerConverter) {
		this.costumerRepo = costumerRepo;
		this.messageUtil = messageUtil;
		this.costumerConverter=costumerConverter;
	}

	public Costumer getCostumerByID(Long id) {
		return this.costumerRepo.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(messageUtil.getMessage("Costumer.notFound", id)));
	}
	
	public CostumerView convertToCostumerView(Costumer costumer)
	{
		return this.costumerConverter.convert(costumer);
	}
	
	
}
