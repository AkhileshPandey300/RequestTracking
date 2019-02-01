package com.pramati.customerrequest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pramati.customerrequest.dao.ContactDAO;
import com.pramati.customerrequest.pojo.Contact;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDAO contactDAO;
	@Override
	public void addContact(Contact contact) {

		contactDAO.addContact(contact);
	}

}
