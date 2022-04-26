package com.bank.NewAccount.Services;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.bank.NewAccount.ConverterView.CostumerConverter;
import com.bank.NewAccount.Entity.Costumer;
import com.bank.NewAccount.Repositories.CostumerRepository;
import com.bank.NewAccount.error.EntityNotFoundException;
import com.bank.NewAccount.util.MessageUtil;
import com.bank.NewAccount.view.CostumerView;

@DataJpaTest
public class CostumerServiceTest {

	private MessageUtil msgUtil = Mockito.mock(MessageUtil.class);

	private CostumerConverter costumerConverter = Mockito.mock(CostumerConverter.class);
	// private AccountService accountService = Mockito.mock(AccountService.class);


	@Autowired
	private CostumerRepository costumerRepository;

	@Autowired
	private TestEntityManager entityManager;
	
	
	@Test
	@DisplayName("Should get costumer by Id")
	public void getCostumerByIDTest()
	{
		CostumerService costumerService = new CostumerService(costumerRepository, msgUtil,costumerConverter);
		Costumer c = entityManager.persist(new Costumer("test", "ben test"));
		Costumer cos =costumerService.getCostumerByID(c.getId());
		Assertions.assertThat(cos.getName()).isEqualTo(c.getName());
		Assertions.assertThat(cos.getSurname()).isEqualTo(c.getSurname());
	}
	
	
	@Test
	@DisplayName("Should throw exception when costumer doesn't exist")
	public void getCostumerByIDTestException()
	{
		CostumerService costumerService = new CostumerService(costumerRepository, msgUtil,costumerConverter);
		assertThrows(EntityNotFoundException.class, () -> {
			costumerService.getCostumerByID((long)1000);
		});
	}
}
