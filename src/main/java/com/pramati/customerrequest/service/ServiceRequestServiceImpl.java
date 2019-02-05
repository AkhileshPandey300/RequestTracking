package com.pramati.customerrequest.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pramati.customerrequest.dao.ActivityDAO;
import com.pramati.customerrequest.dao.ServiceRequestDAO;
import com.pramati.customerrequest.pojo.Activity;
import com.pramati.customerrequest.pojo.ServiceRequest;
import com.pramati.customerrequest.utils.ActivityEnum;

@Service
@Transactional
public class ServiceRequestServiceImpl implements ServiceRequestService {

	@Autowired
	private ServiceRequestDAO serviceRequestDAO;
	@Autowired
	private ActivityDAO activityDAO;

	@Override
	public void createService(ServiceRequest request) {
		this.serviceRequestDAO.createService(request);
		Activity activity = new Activity();
		activity.setSrNumber(request.getSrNumber());
		activity.setCreateDate(new Timestamp(System.currentTimeMillis()));
		activity.setUpdate(ActivityEnum.OPEN.toString());
		activityDAO.loggServiceActivity(activity);

	}

	@Override
	public ServiceRequest editService(ServiceRequest request) {

		ServiceRequest serviceRequest = this.serviceRequestDAO.editService(request);
		if (serviceRequest != null) {
			Activity activity = new Activity();
			activity.setSrNumber(serviceRequest.getSrNumber());
			activity.setCreateDate(new Timestamp(System.currentTimeMillis()));
			activity.setUpdate(ActivityEnum.PROGRESS.toString());
			activityDAO.loggServiceActivity(activity);
		}
		return serviceRequest;
	}

	@Override
	public ServiceRequest getServicesBySrNumber(String srNumber) {
		return this.serviceRequestDAO.getServicesBySrNumber(srNumber);
	}

	@Override
	public List<ServiceRequest> getAllServices() {

		return serviceRequestDAO.getAllServices();
	}

	@Override
	public List<ServiceRequest> findBySpecifications(String specs) {
		return serviceRequestDAO.findBySpecifications(specs);
	}

	@Override
	public ServiceRequest closeService(ServiceRequest request) {

		ServiceRequest serviceRequest = this.serviceRequestDAO.editService(request);
		if (serviceRequest != null) {
			Activity activity = new Activity();
			activity.setSrNumber(serviceRequest.getSrNumber());
			activity.setCreateDate(new Timestamp(System.currentTimeMillis()));
			activity.setUpdate(ActivityEnum.CLOSED.toString());
			activityDAO.loggServiceActivity(activity);
		}
		return serviceRequest;
	}

}
