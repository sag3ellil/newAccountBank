package com.bank.NewAccount;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bank.NewAccount.Entity.Account;
import com.bank.NewAccount.Entity.Costumer;
import com.bank.NewAccount.Repositories.AccountRepository;
import com.bank.NewAccount.Repositories.CostumerRepository;

@SpringBootApplication
public class NewAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewAccountApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(CostumerRepository costumerRepo, AccountRepository accountRepo) {
		return args -> {
			//We create this user to have an existed user for our example  
			Costumer c = new Costumer("Bouraoui", "Ziche");
			costumerRepo.save(c);

		};
	}

}
