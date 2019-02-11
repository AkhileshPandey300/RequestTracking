package com.pramati.customerrequest.dao;

import java.util.List;

import com.pramati.customerrequest.pojo.Account;

public interface AccountDAO {

	public void createCustomerAccount(Account account);

	public Account updateCustomerAccount(Account account);

	public Account findById(Long accountId);

	public List<Account> getAllAccount();

	public List<Account> findBySpecification(String firsName, String lastName);
}
