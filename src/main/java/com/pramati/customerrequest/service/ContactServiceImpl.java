package com.pramati.customerrequest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pramati.customerrequest.pojo.Contact;
import com.pramati.customerrequest.repository.ContactRepository;

@Service
@Transactional
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;

	@Override
	public void addContact(List<Contact> contactList) {

		contactRepository.saveAll(contactList);
	}

}
