package com.bank.NewAccount.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bank.NewAccount.Entity.Costumer;
import com.bank.NewAccount.Requests.AddNewAccountRequest;
import com.bank.NewAccount.Services.AccountService;
import com.bank.NewAccount.Services.CostumerService;
import com.bank.NewAccount.error.EntityNotFoundException;
import com.bank.NewAccount.util.MessageUtil;
import com.bank.NewAccount.view.AccountView;

@RestController
@RequestMapping(path = "/capBE")
public class NewAccountControler {

	private CostumerService costumertSer;
	private AccountService accountSer;
	private MessageUtil messageUtil;

	public NewAccountControler(CostumerService costumertSer, AccountService accountSer, MessageUtil messageUtil) {
		this.costumertSer = costumertSer;
		this.accountSer = accountSer;
		this.messageUtil = messageUtil;
	}

	@PutMapping(value = "/add/newAccount/ExistingCostumer/{customerID}")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public AccountView addAccountToExistingCostumer(@RequestBody AddNewAccountRequest req,
			@PathVariable Long customerID) {
		if (req.getInitialCredit() < 0)
			throw new EntityNotFoundException(
					messageUtil.getMessage("InitialAmount.lessThenZero", req.getInitialCredit()));
		Costumer costumer = this.costumertSer.getCostumerByID(customerID);
		long idNewAcc = this.accountSer.addNewAccountToExistenCost(costumer);

		return this.accountSer.transaction(idNewAcc, req.getInitialCredit());

	}

}
