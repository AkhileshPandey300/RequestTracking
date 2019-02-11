package com.pramati.customerrequest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.pramati.customerrequest.pojo.ServiceRequest;

@Repository
public interface ServiceRequestRepository
		extends JpaRepository<ServiceRequest, String>, JpaSpecificationExecutor<ServiceRequest> {

}
