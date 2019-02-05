package com.pramati.customerrequest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pramati.customerrequest.dao.AccountDAO;
import com.pramati.customerrequest.pojo.Account;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDAO accountDAO;

	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	@Override

	public void createCustomerAccount(Account account) {

		this.accountDAO.createCustomerAccount(account);
	}

	@Override
	public Account updateCustomerAccount(Account account) {

		return this.accountDAO.updateCustomerAccount(account);
	}

	@Override
	public Account findById(Long accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> getAllAccount() {
		return this.accountDAO.getAllAccount();
	}

	@Override
	public List<Account> findBySpecification(String firsName, String lastName) {
			
		return null;
	}

}
