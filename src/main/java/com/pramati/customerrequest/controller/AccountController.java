package com.pramati.customerrequest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	@PostMapping("/add")
	public Account createAccount(@Valid @RequestBody Account account) {
		this.accountService.createCustomerAccount(account);
		return null;
	}

	// edit a account
	@PutMapping("/edit/{id}")
	public Account updateAccount(@PathVariable(value = "id") Long accountId,
			@Valid @RequestBody Account accountDetails) {

		Account updatedAccount = this.accountService.updateCustomerAccount(accountDetails);
		return updatedAccount;
	}

	// get All accounts
	@GetMapping("/get/list")
	public List<Account> getAccounts() {

		List<Account> list = this.accountService.getAllAccount();
		return list;
	}

}
