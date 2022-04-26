package com.bank.NewAccount.Controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.NestedServletException;

import com.bank.NewAccount.Entity.Costumer;
import com.bank.NewAccount.Repositories.AccountRepository;
import com.bank.NewAccount.Repositories.CostumerRepository;
import com.bank.NewAccount.Repositories.TransactionRepository;
import com.bank.NewAccount.Requests.AddNewAccountRequest;
import com.bank.NewAccount.Services.AccountService;
import com.bank.NewAccount.Services.CostumerService;
import com.bank.NewAccount.Services.TransactionTrackService;
import com.bank.NewAccount.error.EntityNotFoundException;
import com.bank.NewAccount.util.MessageUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(NewAccountControler.class)
public class NewAccountControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private CostumerService costumertSer;
	@MockBean
	private AccountService accountSer;
	@MockBean
	private MessageUtil messageUtil;
	@MockBean
	private TransactionTrackService transTrackSer;

	@MockBean
	private CostumerRepository costumerRepository;

	@MockBean
	private AccountRepository accountRepository;

	@MockBean
	private TransactionRepository transactionRepository;

	@Test
	@DisplayName("createNewAccountToExistedCostumer controller test")
	public void createNewAccountToExistedCostumer() throws JsonProcessingException, Exception {
		AddNewAccountRequest req = new AddNewAccountRequest();
		req.setInitialCredit(3.0);

		mockMvc.perform(put("/capBE/add/newAccount/ExistingCostumer/{id}", (long) 1)
				.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(req)))
				.andExpect(status().isCreated());
	}

	@Test
	@DisplayName("createNewAccountToExistedCostumer controller test exception")
	public void createNewAccountToExistedCostumerException() throws JsonProcessingException, Exception {
		AddNewAccountRequest req = new AddNewAccountRequest();
		req.setInitialCredit(-1.00);
		assertThrows(NestedServletException.class, () -> {
			mockMvc.perform(put("/capBE/add/newAccount/ExistingCostumer/{id}", (long) 1)
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(req)))
					.andExpect(status().isInternalServerError())
					.andExpect(result -> assertTrue(result.getResolvedException() instanceof EntityNotFoundException));

		});
	}

	@Test
	@DisplayName("Get Accounts by costumer ID")
	public void getAccountByCostumerID() throws Exception
	{
		//String[] s = null ;
		mockMvc.perform(get("/capBE/getAccountsByCostumer/{customerID}", (long) 1))
				.andExpect(status().isOk())
				//.andExpect(jsonPath("$.name").value("Bouraoui"))
		        //.andExpect(jsonPath("$.surname").value("Ziche"))
		        //.andExpect(jsonPath("$.accounts").value(s))
		        //.andExpect(jsonPath("$.id").value(1))
		        .andDo(print());
	}

}
