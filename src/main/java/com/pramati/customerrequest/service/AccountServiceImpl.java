package com.pramati.customerrequest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pramati.customerrequest.exception.AccountNotFoundException;
import com.pramati.customerrequest.pojo.Account;
import com.pramati.customerrequest.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	@Transactional
	public Account createCustomerAccount(Account account) {

		Account accountEntity = this.accountRepository.save(account);
		return accountEntity;
	}

	@Override
	@Transactional
	public Account updateCustomerAccount(Account account) throws AccountNotFoundException {

		Optional<Account> accountOpt = accountRepository.findById(account.getAccountId());

		if (!accountOpt.isPresent())
			throw new AccountNotFoundException("Not Found");

		return this.accountRepository.save(account);

	}

	@Override
	@Transactional
	public Account findById(Long accountId) throws AccountNotFoundException {
		return accountRepository.findById(accountId)
				.orElseThrow(() -> new AccountNotFoundException("Account Does Not Exsist"));
	}

	@Override
	@Transactional
	public Page<Account> getAllAccount(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return this.accountRepository.findAll(pageable);
	}

	@Override
	@Transactional
	public Page<Account> findBySpecification(String firstName, String lastName, int page, int size) {
		Pageable sortedByPriceDescNameAsc = PageRequest.of(page, size,
				Sort.by("firstName").descending().and(Sort.by("lastName")));

		return accountRepository.findByFirstNameAndLastName(firstName, lastName, sortedByPriceDescNameAsc);
	}

}
