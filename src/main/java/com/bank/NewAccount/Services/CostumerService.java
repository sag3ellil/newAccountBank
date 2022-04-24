package com.bank.NewAccount.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.NewAccount.Entity.Costumer;
import com.bank.NewAccount.Repositories.CostumerRepository;
import com.bank.NewAccount.error.EntityNotFoundException;
import com.bank.NewAccount.util.MessageUtil;

@Service
public class CostumerService {

	private final CostumerRepository costumerRepo;
	private final MessageUtil messageUtil;

	public CostumerService(CostumerRepository costumerRepo, MessageUtil messageUtil) {
		this.costumerRepo = costumerRepo;
		this.messageUtil = messageUtil;
	}

	public Costumer addNewCostumer(Costumer costumer) {
		return costumerRepo.save(costumer);
	}

	public List<Costumer> getAllCostumers() {
		return costumerRepo.findAll();
	}

	public Costumer getCostumerByID(Long id) {
		return this.costumerRepo.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(messageUtil.getMessage("Costumer.notFound", id)));
	}
}
