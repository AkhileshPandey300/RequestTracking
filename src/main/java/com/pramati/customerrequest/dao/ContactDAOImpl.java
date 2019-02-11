package com.pramati.customerrequest.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.pramati.customerrequest.pojo.Contact;

@Repository
public class ContactDAOImpl implements ContactDAO {

	private static final Logger logger = LoggerFactory.getLogger(ContactDAOImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void addContact(Contact contact) {
		if (contact.getContactId() > 0) {
			entityManager.persist(contact);
		} else {
			entityManager.merge(contact);
		}
		logger.info("" + contact);

	}

}
