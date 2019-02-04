package com.pramati.customerrequest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pramati.customerrequest.dao.ServiceRequestDAO;
import com.pramati.customerrequest.pojo.ServiceRequest;

@Service
@Transactional
public class ServiceRequestServiceImpl implements ServiceRequestService {

	@Autowired
	private ServiceRequestDAO serviceRequestDAO;

	@Override
	public void createService(ServiceRequest request) {
		serviceRequestDAO.editService(request);

	}

	@Override
	public ServiceRequest editService(ServiceRequest request) {

		return null;
	}

	@Override
	public ServiceRequest getServicesBySrNumber(String srNumber) {

		return null;
	}

	@Override
	public List<ServiceRequest> getAllServices() {

		return null;
	}

}
