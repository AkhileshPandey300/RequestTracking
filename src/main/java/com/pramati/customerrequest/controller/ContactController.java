package com.pramati.customerrequest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pramati.customerrequest.pojo.Contact;
import com.pramati.customerrequest.service.ContactService;

@RestController
public class ContactController {

	@Autowired
	private ContactService contactService;

	@PostMapping()
	public void addContact(@Valid @RequestBody Contact contact) {

		contactService.addContact(contact);
	}

}
