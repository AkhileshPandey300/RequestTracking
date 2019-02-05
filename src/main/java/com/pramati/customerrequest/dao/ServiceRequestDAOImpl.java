package com.pramati.customerrequest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.pramati.customerrequest.pojo.ServiceRequest;
import com.pramati.customerrequest.utils.DateConvertor;

@Repository
public class ServiceRequestDAOImpl implements ServiceRequestDAO {

	private static final Logger logger = LoggerFactory.getLogger(ServiceRequestDAOImpl.class);

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

		ServiceRequest serviceRequest = entityManager
				.createQuery("select sr " + "from SERVICEREQUEST sr " + "where sr.srNumber = :srNumber",
						ServiceRequest.class)
				.setParameter("srNumber", srNumber).getSingleResult();
		return serviceRequest;
	}

	@Override
	public List<ServiceRequest> getAllServices() {

		List<ServiceRequest> ListOfAllServiceRequest = entityManager
				.createQuery("select  from SERVICEREQUEST ", ServiceRequest.class).getResultList();
		return ListOfAllServiceRequest;
	}

	@Override
	public List<ServiceRequest> findBySpecifications(String specs) {
		String[] specsArray = specs.split(",");
		try {
			long accountId = Long.parseLong(specsArray[0]);
			String openFrom = specsArray[1];
			String openTo = specsArray[2];
			String closedFrom = specsArray[3];
			String closedTo = specsArray[4];
			String status = specsArray[5];

			List<ServiceRequest> listOfServices = this.entityManager
					.createQuery("SELECT sr " + "FROM SERVICEREQUEST sr " + "where sr.accountId = :accountId"
							+ " AND sr.status = :status" + " AND sr.openDate BETWEEN :openFrom AND :openTo"
							+ "  AND sr.closeDate BETWEEN :closedFrom AND :closedTo", ServiceRequest.class)
					.setParameter("accountId", accountId).setParameter("status", status)
					.setParameter("openFrom", DateConvertor.convertStringToTimestamp(openFrom))
					.setParameter("openTo", DateConvertor.convertStringToTimestamp(openTo))
					.setParameter("closedFrom", DateConvertor.convertStringToTimestamp(closedFrom))
					.setParameter("closedTo", DateConvertor.convertStringToTimestamp(closedTo)).getResultList();
			return listOfServices;

		} catch (ArrayIndexOutOfBoundsException e) {

			logger.error(e.getMessage());
		}

		return null;
	}

}
