package com.bank.NewAccount.Services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.bank.NewAccount.ConverterView.TransactionConverter;
import com.bank.NewAccount.Entity.Account;
import com.bank.NewAccount.Entity.Costumer;
import com.bank.NewAccount.Repositories.AccountRepository;
import com.bank.NewAccount.Repositories.CostumerRepository;
import com.bank.NewAccount.Repositories.TransactionRepository;
import com.bank.NewAccount.util.MessageUtil;
import com.bank.NewAccount.view.TransactionView;

@DataJpaTest
public class TransactionTrackServiceTest {

	private MessageUtil msgUtil = Mockito.mock(MessageUtil.class);

	private TransactionConverter transactionConverter = new TransactionConverter();
	// private AccountService accountService = Mockito.mock(AccountService.class);

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private CostumerRepository costumerRepository;

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private TestEntityManager entityManager;

	@Test
	@DisplayName("save transaction test")
	public void saveTransaction() {
		TransactionTrackService transactionService = new TransactionTrackService(transactionRepository, msgUtil,
				transactionConverter);
		Costumer c = entityManager.persist(new Costumer("test", "ben test",0.0));
		Costumer cToUse = costumerRepository.save(c);
		Account account = entityManager.persist(new Account(0.0, cToUse));

		Account accToUse = accountRepository.save(account);
		TransactionView view = transactionService.saveTransaction(accToUse, 20.0);
		Assertions.assertThat(view.getAmount()).isEqualTo(20.0);
	}
}
