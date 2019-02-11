package com.pramati.customerrequest.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.pramati.customerrequest.pojo.Account;
import com.pramati.customerrequest.pojo.Contact;
import com.pramati.customerrequest.repository.ContactRepository;
import com.pramati.customerrequest.service.ContactServiceImpl;

class ContactServiceImplTest {

	@Autowired
	TestRestTemplate restTemplate;

	@InjectMocks
	ContactServiceImpl contactServiceImpl;

	@Mock
	ContactRepository contactRepository;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testAddContact() {

		Account ac = new Account();
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

		Contact contact = new Contact();
		contact.setAccount(ac);
		contact.setContactId(1);
		contact.setCreatedAt(null);
		contact.setCreatedBy("");
		contact.setFirstName("TestName");
		contact.setLastName("TLast");
		contact.setEmail("a@gmail.com");
		contact.setPhoneNumber("8787878787");

		Contact resultContact = contactRepository.save(contact);
		assertNotNull(resultContact);
		assertEquals(contact.getFirstName(), resultContact.getFirstName());
		assertEquals(contact.getLastName(), resultContact.getLastName());

		/*
		 * ResponseEntity<Boolean> responseEntity = restTemplate.postForEntity("/add",
		 * contact, Boolean.class); assertEquals(CREATED,
		 * responseEntity.getStatusCode()); assertEquals(true,
		 * responseEntity.getBody());
		 * 
		 * ResponseEntity<Contact> responseEntity2 = restTemplate.getForEntity("/books",
		 * Contact.class); assertEquals(responseEntity2.getBody().getEmail(),
		 * "a@gmail.com");
		 */

	}

}
