package com.pramati.customerrequest.requestservices;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pramati.customerrequest.pojo.Account;
import com.pramati.customerrequest.repository.AccountRepository;

@WebMvcTest(controllers = AccountControllerTest.class)
@RunWith(SpringRunner.class)
class AccountControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	AccountRepository accountService;

	@Autowired
	ObjectMapper objectMapper;

	Account account;
	private final String URL = "/accounts";

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

		given(this.accountService.findById(1L)).willReturn(Optional.of(Account.builder().firstName("test").build()));

		given(this.accountService.findById(2L)).willReturn(Optional.empty());

		given(this.accountService.save(any(Account.class))).willReturn(Account.builder().firstName("test").build());

		doNothing().when(this.accountService).delete(any(Account.class));

	}

	@Test
	void testCreateAccount() throws JsonProcessingException, Exception {
		this.mockMvc.perform(
				post(URL).content(this.objectMapper.writeValueAsBytes(Account.builder().firstName("test").build()))
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());

		verify(this.accountService, times(1)).save(any(Account.class));
		verifyNoMoreInteractions(this.accountService);
	}

	@Test
	void testUpdateAccount() throws JsonProcessingException, Exception {

		this.mockMvc.perform(
				put(URL + "/1").content(this.objectMapper.writeValueAsBytes(Account.builder().firstName("test").build()))
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());

		verify(this.accountService, times(1)).findById(any(Long.class));
		verify(this.accountService, times(1)).save(any(Account.class));
		verifyNoMoreInteractions(this.accountService);
	}

	@Test
	void testSearchAccounts() {
//		when(accountService.findBySpecification(anyString(), anyString())).thenReturn(null);
	}

	@Test
	void testGetAccounts() throws Exception {
		this.mockMvc.perform(get(URL).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.firstName").value("test"));

		verify(this.accountService, times(1)).findById(any(Long.class));
		verifyNoMoreInteractions(this.accountService);

	}

}
