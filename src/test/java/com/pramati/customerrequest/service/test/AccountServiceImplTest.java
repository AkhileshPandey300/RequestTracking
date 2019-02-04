package com.pramati.customerrequest.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.pramati.customerrequest.dao.AccountDAO;
import com.pramati.customerrequest.pojo.Account;
import com.pramati.customerrequest.service.AccountServiceImpl;

class AccountServiceImplTest {
	
	@InjectMocks
	private AccountServiceImpl accountService;
	@Mock
	private AccountDAO accountDAO;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void getAllAccount() {
		when(accountDAO.getAllAccount()).thenReturn(null);
		Account ac = new Account();
		Account account = accountService.updateCustomerAccount(ac);
		assertNotNull(account);
		assertEquals("test" ,account.getFirstName());
	
	}

}
