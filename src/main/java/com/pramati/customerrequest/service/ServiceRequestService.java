package com.pramati.customerrequest.service;

import java.util.List;

import com.pramati.customerrequest.pojo.ServiceRequest;

public interface ServiceRequestService {
	
	public void createService(ServiceRequest request);
	public ServiceRequest editService(ServiceRequest request);
	public ServiceRequest getServicesBySrNumber(String srNumber);
	public List<ServiceRequest> getAllServices();
	public List<ServiceRequest> findBySpecifications(String specs);
	public ServiceRequest closeService(ServiceRequest request);
	

}
