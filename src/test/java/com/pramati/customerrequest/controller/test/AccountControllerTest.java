package com.pramati.customerrequest.controller.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.pramati.customerrequest.controller.AccountController;
import com.pramati.customerrequest.pojo.Account;
import com.pramati.customerrequest.service.AccountService;

class AccountControllerTest {

	@InjectMocks
	AccountController accountController;

	@Mock
	AccountService accountService;

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
		account.setFirstName("TestName");
		account.setLastName("TLast");
		account.setState("Tel");
		account.setZipcode("1007");
	}

	@Test
	void testCreateAccount() {

	}

	@Test
	void testUpdateAccount() {
		fail("Not yet implemented");
	}

	@Test
	void testSearchAccounts() {
//		when(accountService.findBySpecification(anyString(), anyString())).thenReturn(null);
	}

	@Test
	void testGetAccounts() {
		List<Account> list = new ArrayList<>();
		/*
		 * list.add(account); when(accountService.getAllAccount()).thenReturn(list);
		 * List<Account> listAccounts = accountController.getAccounts();
		 * assertNotNull(listAccounts); assertEquals(list.get(0).getAccountId(),
		 * listAccounts.get(0).getAccountId()); assertTrue(list.size() ==
		 * listAccounts.size());
		 */

	}

}
