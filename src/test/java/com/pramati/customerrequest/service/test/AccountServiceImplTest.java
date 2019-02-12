package com.pramati.customerrequest.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.pramati.customerrequest.exception.AccountNotFoundException;
import com.pramati.customerrequest.pojo.Account;
import com.pramati.customerrequest.repository.AccountRepository;
import com.pramati.customerrequest.service.AccountServiceImpl;

class AccountServiceImplTest {

	@InjectMocks
	AccountServiceImpl accountService;
	@Mock
	AccountRepository accountRepository;

	Account ac;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		ac = new Account();
		ac.setAccountId((long) 1);
		ac.setAddress1("Banjara");
		ac.setAddress2("Hills");
		ac.setCity("Hyd");
		ac.setCreatedAt(null);
		ac.setCreatedBy("");
		ac.setFirstName("TestName");
		ac.setLastName("TLast");
		ac.setState("Tel");
		ac.setZipcode("1007");
	}

	@Test
	void getAllAccount() {
		/*
		 * List<Account> listOfAccounts = new ArrayList<>(); listOfAccounts.add(ac);
		 * Pageable page = PageRequest.of(0, 5);
		 * when(accountRepository.findByFirstNameAndLastName("TestName", "TLast",
		 * page)).thenReturn(listOfAccounts);
		 * 
		 * assertNotNull(ac); assertEquals("TestName",
		 * listOfAccounts.get(0).getFirstName());
		 */ }

	@Test
	void createCustomerAccount() {
//		Account account = accountRepository.save(ac);
		Account account = (Account) when(accountRepository.save(Mockito.any(Account.class))).thenReturn(ac);
		assertNotNull(account);
		assertEquals(ac.getFirstName(), account.getFirstName());
		assertEquals(ac.getLastName(), account.getLastName());

	}

	@Test
	void findById() {

		when(accountRepository.findById(Mockito.anyLong())).thenReturn(null);
		Assertions.assertThrows(AccountNotFoundException.class,

				() -> {
					accountService.findById((long) 1);
				});
	}

	@Test
	void updateCustomerAccount() {

	}

	@Test
	void findBySpecification() {
		/*
		 * List<Account> listOfAccounts = new ArrayList<>(); listOfAccounts.add(ac);
		 * Pageable page = PageRequest.of(0, 5); OngoingStubbing<List<Account>> test =
		 * when( accountRepository.findByFirstNameAndLastName("TestName", "TLast",
		 * page)).thenReturn(listOfAccounts);
		 * 
		 * assertNotNull(test);
		 */ }

}
