package com.pramati.customerrequest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pramati.customerrequest.exception.AccountNotFoundException;
import com.pramati.customerrequest.pojo.Account;
import com.pramati.customerrequest.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	// Create a new Account
	@PostMapping("/")
	public Account createAccount(@Valid @RequestBody Account account) {
		return this.accountService.createCustomerAccount(account);
	}

	// edit a account
	@PutMapping("/{id}")
	public Account updateAccount(@PathVariable(value = "id") Long accountId, @Valid @RequestBody Account accountDetails)
			throws AccountNotFoundException {

		accountDetails.setAccountId(accountId);
		return this.accountService.updateCustomerAccount(accountDetails);
	}

	@GetMapping("/{firstName}/{lastName}")
	public Page<Account> searchAccounts(@PathVariable(value = "firstName") String firstName,
			@PathVariable(value = "lastName") String lastName, @RequestParam("page") int page,
			@RequestParam("size") int size) {

		return this.accountService.findBySpecification(firstName, lastName, page, size);

	}

	// get All accounts
	@GetMapping("/")
	public Page<Account> getAccounts(@RequestParam("page") int page, @RequestParam("size") int size) {

		return this.accountService.getAllAccount(page, size);
	}

}
