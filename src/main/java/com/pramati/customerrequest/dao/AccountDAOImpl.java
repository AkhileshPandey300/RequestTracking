package com.pramati.customerrequest.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.pramati.customerrequest.pojo.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {

	private static final Logger logger = LoggerFactory.getLogger(AccountDAOImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void createCustomerAccount(Account account) {
		Session session = entityManager.unwrap(Session.class);
		session.persist(account);
		logger.info("" + account);

	}

	@Override
	public Account updateCustomerAccount(Account account) {

		Session session = entityManager.unwrap(Session.class);
		session.update(account);

		return account;

	}

	@Override
	public Account findById(Long accountId) {
		return null;
	}

	@Override
	public List<Account> getAllAccount() {
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createNativeQuery("SELECT * FROM ACCOUNT ;");
		/*
		 * ((org.hibernate.query.Query)
		 * query).setResultTransformer(Transformers.aliasToBean(Account.class));
		 * ArrayList<Account> list = (ArrayList<Account>) query.getResultList();
		 */
		ArrayList<Account> list = (ArrayList<Account>) query.list();

		return list;
	}

}
