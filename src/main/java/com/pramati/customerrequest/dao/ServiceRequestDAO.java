package com.pramati.customerrequest.dao;

import java.util.List;

import com.pramati.customerrequest.pojo.ServiceRequest;

public interface ServiceRequestDAO {

	public void createService(ServiceRequest request);

	public ServiceRequest editService(ServiceRequest request);

	public ServiceRequest getServicesBySrNumber(String srNumber);

	public List<ServiceRequest> getAllServices();

	public List<ServiceRequest> findBySpecifications(String specs);

}
