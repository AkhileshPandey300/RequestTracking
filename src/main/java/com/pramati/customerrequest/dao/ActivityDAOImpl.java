package com.pramati.customerrequest.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.pramati.customerrequest.pojo.Activity;

@Repository
public class ActivityDAOImpl implements ActivityDAO {

	private static final Logger logger = LoggerFactory.getLogger(ActivityDAOImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void loggServiceActivity(Activity activity) {
		try {
			this.entityManager.persist(activity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
