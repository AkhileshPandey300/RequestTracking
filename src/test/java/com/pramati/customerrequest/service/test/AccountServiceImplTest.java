package com.pramati.customerrequest.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import com.pramati.customerrequest.exception.AccountNotFoundException;
import com.pramati.customerrequest.pojo.Account;
import com.pramati.customerrequest.pojo.Contact;
import com.pramati.customerrequest.repository.AccountRepository;
import com.pramati.customerrequest.service.AccountServiceImpl;

class AccountServiceImplTest {

	@InjectMocks
	AccountServiceImpl accountServiceImpl;
	@Mock
	AccountRepository accountRepository;

	Account account;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		account = new Account();
		account.setAccountId((long) 1);
		account.setAddress1("Banjara");
		account.setAddress2("Hills");
		account.setCity("Hyd");
		account.setCreatedAt(null);
		account.setCreatedBy("");
		account.setFirstName("Test");
		account.setLastName("Last");
		account.setState("Tel");
		account.setZipcode("400709");
	}

	@Test
	void getAllAccount() {
		List<Contact> contacts = null;
		List<Account> listOfAccounts = new ArrayList<>();
		listOfAccounts.add(new Account("", "", null, null, (long) 1, "Test", "Last", "Banjara", "Hills", "Hyd", "Tel",
				"400709", contacts));
		when(accountRepository.findAll()).thenReturn(listOfAccounts);
		Page<Account> pageResult = accountServiceImpl.getAllAccount(0, 1);
		if (pageResult != null) {
			List<Account> listResult = pageResult.getContent();
			assertEquals(1, listResult.size());
		}
	}

	@Test
	void createCustomerAccount() {
		when(accountRepository.save(account)).thenReturn(account);
		Account resultAccount = accountServiceImpl.createCustomerAccount(account);
		assertNotNull(resultAccount);
		assertEquals(account.getAccountId(), resultAccount.getAccountId());
		assertEquals(account.getAddress1(), resultAccount.getAddress1());
	}

	@Test
	void findById() {
		Optional<Account> opAcc = Optional.of(account);
		when(accountRepository.findById(1L)).thenReturn(opAcc);
		Account result;
		try {
			result = accountServiceImpl.findById(1L);
			assertEquals(account.getAccountId(), result.getAccountId());
			assertEquals(account.getAddress1(), result.getAddress1());
		} catch (AccountNotFoundException e) {
			e.printStackTrace();
		}
		when(accountRepository.findById(1L)).thenReturn(opAcc);

		Assertions.assertThrows(AccountNotFoundException.class,

				() -> {
					accountServiceImpl.findById(121313L);
				});
	}

	@Test
	void updateCustomerAccount() {
		when(accountRepository.save(account)).thenReturn(account);
		Assertions.assertThrows(AccountNotFoundException.class,

				() -> {
					accountServiceImpl.updateCustomerAccount(account);
				});
		Account resultAccount;
		try {
			resultAccount = accountServiceImpl.updateCustomerAccount(account);

			assertNotNull(resultAccount);
			assertEquals(account.getAccountId(), resultAccount.getAccountId());
			assertEquals(account.getAddress1(), resultAccount.getAddress1());
		} catch (AccountNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test
	void findBySpecification() {
		List<Account> listAccount = new ArrayList<Account>();
		listAccount.add(account);
		Pageable pagiWithSort = PageRequest.of(0, 1, Sort.by("firstName").descending().and(Sort.by("lastName")));
		Page<Account> pageAccount = new PageImpl<>(listAccount);
		when(accountRepository.findByFirstNameAndLastName("Test", "Last", pagiWithSort)).thenReturn(pageAccount);
		Page<Account> resultPageAccount = accountServiceImpl.findBySpecification("Test", "Last", 0, 1);
		List<Account> resultAccountList = resultPageAccount.getContent();
		assertNotNull(resultAccountList);
		assertTrue(listAccount.size() == resultAccountList.size());
	}
}
