package com.bank.NewAccount.Services;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.bank.NewAccount.ConverterView.AccountConverter;
import com.bank.NewAccount.Entity.Account;
import com.bank.NewAccount.Entity.Costumer;
import com.bank.NewAccount.Repositories.AccountRepository;
import com.bank.NewAccount.error.EntityNotFoundException;
import com.bank.NewAccount.util.MessageUtil;
import com.bank.NewAccount.view.AccountView;

@DataJpaTest
public class AccountServiceTest {

	private AccountConverter accountConverter = new AccountConverter();

	private MessageUtil msgUtil = Mockito.mock(MessageUtil.class);

	// private AccountService accountService = Mockito.mock(AccountService.class);

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private TestEntityManager entityManager;

	@Test
	@DisplayName("Should find account by costumer Id")
	public void getAccountsByCostumerID() throws Exception {
		AccountService accountService = new AccountService(accountRepository, accountConverter, msgUtil);
		Costumer c = entityManager.persist(new Costumer("test", "ben test"));
		List<Account> lstAcc = accountService.getAccountsByCostumerID(c.getId());
		List<Account> accountExpected = new ArrayList<>();
		Assertions.assertThat(lstAcc).isEqualTo(accountExpected);
	}

	@Test
	@DisplayName("Should add account to existed costumer with 0 as amount")
	public void addNewAccountToExistenCostTest() throws Exception {
		AccountService accountService = new AccountService(accountRepository, accountConverter, msgUtil);

		Costumer c = entityManager.persist(new Costumer("test", "ben test"));

		long id = accountService.addNewAccountToExistenCost(c);
		Assertions.assertThat(id).isNotEqualTo(null);
	}

	@Test
	@DisplayName("convert Account entity To View")
	public void convertToViewTest() {
		AccountService accountService = new AccountService(accountRepository, accountConverter, msgUtil);

		Account a = new Account();
		Costumer cos = new Costumer("name","surname"); 
		a.setAmount(20.0);
		a.setCostumer(cos);

		AccountView accView = accountService.convertToView(a);
		AccountView accViewExpected = new AccountView();
		accViewExpected.setAmount(20.0);
		accViewExpected.setCostumer(cos);
		Assertions.assertThat(accView.getAmount()).isEqualTo(accViewExpected.getAmount());
		Assertions.assertThat(accView.getCostumer().getName()).isEqualTo(accViewExpected.getCostumer().getName());
		Assertions.assertThat(accView.getCostumer().getSurname()).isEqualTo(accViewExpected.getCostumer().getSurname());
	}

	@Test
	@DisplayName("Transaction Test : should do the transaction if every thing is fine")
	public void TransactionTest() {
		AccountService accountService = new AccountService(accountRepository, accountConverter, msgUtil);

		Costumer c = entityManager.persist(new Costumer("test", "ben test"));
		Account a = entityManager.persist(new Account(0.0, c));
		a.setAmount(30.0);
		Account expected = this.accountRepository.save(a);
		Account b = accountService.transaction(a.getId(), 30.0);
		Assertions.assertThat(b).isEqualTo(expected);
	}

	@Test
	@DisplayName("Transaction Test : should generate an exception if the account doesn't exsit")
	public void TransactionTestException() {
		AccountService accountService = new AccountService(accountRepository, accountConverter, msgUtil);

		assertThrows(EntityNotFoundException.class, () -> {
			accountService.transaction(9, 30.0);
		});
	}
}
