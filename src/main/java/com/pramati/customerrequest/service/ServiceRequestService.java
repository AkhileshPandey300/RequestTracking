package com.pramati.customerrequest.service;

import java.util.Map;

import org.springframework.data.domain.Page;

import com.pramati.customerrequest.pojo.ServiceRequest;

public interface ServiceRequestService {

	public ServiceRequest createService(ServiceRequest request);

	public ServiceRequest editService(ServiceRequest request);

	public ServiceRequest getServicesBySrNumber(String srNumber);

	public Page<ServiceRequest> getAllServices(int page, int size);

//	public Page<ServiceRequest> findBySpecifications(String specs,int page, int size);

	public Page<ServiceRequest> findBySpecifications(Map<String, String> paramMap,int page, int size);
	public ServiceRequest closeService(ServiceRequest request);

}
