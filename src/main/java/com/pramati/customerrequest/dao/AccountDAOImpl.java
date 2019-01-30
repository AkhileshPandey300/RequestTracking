package com.pramati.customerrequest.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.pramati.customerrequest.pojo.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {

	private static final Logger logger = LoggerFactory.getLogger(AccountDAOImpl.class);

	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void createCustomerAccount(Account account) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(account);
		logger.info("" + account);

	}

	@Override
	public Account updateCustomerAccount(Account account) {

		Session session = this.sessionFactory.getCurrentSession();
		 session.update(account);
		 
		 return account;
		
	}

	@Override
	public Account findById(Long accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> getAllAccount() {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("* From ACCOUNT"); 
		List<Account> list=query.getResultList();
		 
		return list;
	}

	

}
