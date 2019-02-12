package com.pramati.customerrequest.requestservices;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.pramati.customerrequest.controller.AccountController;
import com.pramati.customerrequest.pojo.Account;
import com.pramati.customerrequest.service.AccountService;
import com.pramati.customerrequest.utils.TestUtils;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AccountController.class)
@ContextConfiguration
class AccountControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	AccountService accountService;

	Account account;
	private final String URL = "/accounts/";

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
		try {
			// prepare data and mock's behaviour
			when(accountService.createCustomerAccount(any(Account.class))).thenReturn(account);

			// execute
			MvcResult result = mockMvc
					.perform(MockMvcRequestBuilders.post(URL).contentType(MediaType.APPLICATION_JSON_UTF8)
							.accept(MediaType.APPLICATION_JSON_UTF8).content(TestUtils.objectToJson(account)))
					.andReturn();

			// verify
			int status = result.getResponse().getStatus();
			assertEquals(HttpStatus.CREATED.value(), status, "Incorrect Response Status");

			// verify that service method was called once
			verify(accountService).createCustomerAccount(any(Account.class));

			Account resultAccount = TestUtils.jsonToObject(result.getResponse().getContentAsString(), Account.class);
			assertNotNull(resultAccount);

		} catch (Exception e) {

		}
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
