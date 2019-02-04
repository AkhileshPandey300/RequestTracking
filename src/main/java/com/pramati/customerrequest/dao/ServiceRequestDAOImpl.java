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

import com.pramati.customerrequest.pojo.ServiceRequest;

@Repository
public class ServiceRequestDAOImpl implements ServiceRequestDAO {

	private static final Logger logger = LoggerFactory.getLogger(AccountDAOImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void createService(ServiceRequest request) {
		Session session = entityManager.unwrap(Session.class);
		session.persist(request);
		logger.info("" + request);

	}

	@Override
	public ServiceRequest editService(ServiceRequest request) {

		Session session = entityManager.unwrap(Session.class);
		session.update(request);

		return request;
	}

	@Override
	public ServiceRequest getServicesBySrNumber(String srNumber) {

		Session session = entityManager.unwrap(Session.class);
		return (ServiceRequest) session.byId(srNumber);
	}

	@Override
	public List<ServiceRequest> getAllServices() {

		Session session = entityManager.unwrap(Session.class);
		Query query = session.createNativeQuery("SELECT * FROM " + ServiceRequest.class + ";");

		ArrayList<ServiceRequest> list = (ArrayList<ServiceRequest>) query.list();

		return list;
	}

}
