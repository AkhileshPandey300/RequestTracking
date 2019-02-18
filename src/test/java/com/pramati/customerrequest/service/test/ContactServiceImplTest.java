package com.pramati.customerrequest.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.pramati.customerrequest.pojo.Account;
import com.pramati.customerrequest.pojo.Contact;
import com.pramati.customerrequest.repository.ContactRepository;
import com.pramati.customerrequest.service.ContactServiceImpl;

class ContactServiceImplTest {

	@InjectMocks
	ContactServiceImpl contactServiceImpl;

	@Mock
	ContactRepository contactRepository;
	Contact contact;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testAddContact() {
		Account ac = new Account();
		ac.setAccountId(1L);
		ac.setAddress1("Banjara");
		ac.setAddress2("Hills");
		ac.setCity("Hyd");
		ac.setCreatedAt(null);
		ac.setCreatedBy("");
		ac.setFirstName("Test");
		ac.setLastName("Last");
		ac.setState("Tel");
		ac.setZipcode("400709");

		contact = new Contact();
		contact.setAccount(ac);
		contact.setContactId(1L);
		contact.setCreatedAt(null);
		contact.setCreatedBy("");
		contact.setFirstName("Test2");
		contact.setLastName("Last2");
		contact.setEmail("test@gmail.com");
		contact.setPhoneNumber("8693896061");
		List<Contact> listOfContacts = new ArrayList<>();
		listOfContacts.add(contact);
		when(contactRepository.save(contact)).thenReturn(contact);
		List<Contact> resultListContact = contactServiceImpl.addContact(listOfContacts);
//		assertNotNull(resultListContact);
//		assertEquals(contact.getAccount().getAccountId(), resultListContact.get(0).getAccount().getAccountId());
//		assertTrue(listOfContacts.size() == resultListContact.size());
	}

}
