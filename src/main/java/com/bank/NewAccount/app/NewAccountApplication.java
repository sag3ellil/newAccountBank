package com.bank.NewAccount.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
@EnableCaching     // enabling caching in the application
@SpringBootApplication
public class NewAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewAccountApplication.class, args);
	}

}
