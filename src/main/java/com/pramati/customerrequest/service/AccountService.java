package com.pramati.customerrequest.service;

import org.springframework.data.domain.Page;

import com.pramati.customerrequest.exception.AccountNotFoundException;
import com.pramati.customerrequest.pojo.Account;

public interface AccountService {

	public Account createCustomerAccount(Account account);

	public Account updateCustomerAccount(Account account) throws AccountNotFoundException;

	public Account findById(Long accountId) throws AccountNotFoundException;
	
	public Page<Account> getAllAccount(int page, int size);

	public Page<Account> findBySpecification(String firstName, String lastName, int page, int size);

}
