package com.bank.NewAccount.Services;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.bank.NewAccount.ConverterView.TransactionConverter;
import com.bank.NewAccount.Entity.Account;
import com.bank.NewAccount.Entity.Transaction;
import com.bank.NewAccount.Repositories.TransactionRepository;
import com.bank.NewAccount.util.MessageUtil;
import com.bank.NewAccount.view.TransactionView;

@Service
public class TransactionTrackService {

	private final TransactionRepository transactionRepo;
	private final MessageUtil messageUtil;
	private final TransactionConverter transactionConv;

	public TransactionTrackService(TransactionRepository transactionRepo, MessageUtil messageUtil,
			TransactionConverter transactionConv) {
		this.messageUtil = messageUtil;
		this.transactionRepo = transactionRepo;
		this.transactionConv = transactionConv;
	}

	public TransactionView saveTransaction(Account account, Double amount) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		Transaction transaction = new Transaction(amount, formatter.format(date), account);
		Transaction transToReturn = this.transactionRepo.save(transaction);
		return this.convertToView(transToReturn);
	}

	public TransactionView convertToView(Transaction t) {
		return this.transactionConv.convert(t);
	}
}
