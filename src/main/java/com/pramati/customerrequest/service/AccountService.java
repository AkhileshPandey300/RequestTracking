package com.pramati.customerrequest.service;

import java.util.List;

import com.pramati.customerrequest.pojo.Account;


public interface AccountService  {
	
	public void createCustomerAccount(Account account);
	public Account updateCustomerAccount(Account account);
	public Account findById(Long accountId);
	public List<Account> getAllAccount();

}
