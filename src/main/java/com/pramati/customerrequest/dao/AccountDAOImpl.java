package com.pramati.customerrequest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
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
		Account account = entityManager
				.createQuery("select acc " + "from Account acc " + "where acc.accountId = :id", Account.class)
				.setParameter("accountId", accountId).getSingleResult();
		return account;
	}

	@Override
	public List<Account> getAllAccount() {
		List<Account> listOfAllAccounts = entityManager.createQuery("select * from Account ", Account.class)
				.getResultList();

		return listOfAllAccounts;
	}

	@Override
	public List<Account> findBySpecification(String firsName, String lastName) {

		List<Account> listOfAccounts = entityManager
				.createQuery("select acc " + "from Account acc "
						+ "where acc.firstName = :firsName and acc.lastName = :lastName", Account.class)
				.setParameter("firsName", firsName).setParameter("lastName", lastName).getResultList();

		return listOfAccounts;
	}

}
