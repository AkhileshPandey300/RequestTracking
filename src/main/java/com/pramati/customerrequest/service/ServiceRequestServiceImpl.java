package com.pramati.customerrequest.service;

import java.sql.Timestamp;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.transaction.Transactional;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.google.common.base.Joiner;
import com.pramati.customerrequest.pojo.Activity;
import com.pramati.customerrequest.pojo.ServiceRequest;
import com.pramati.customerrequest.repository.ServiceRequestRepository;
import com.pramati.customerrequest.utils.ActivityEnum;
import com.pramati.customerrequest.utils.SRSpecificationsBuilder;
import com.pramati.customerrequest.utils.SearchOperation;

@Service
@Transactional
public class ServiceRequestServiceImpl implements ServiceRequestService {

	@Autowired
	private ServiceRequestRepository serviceRequestRepository;
	@Autowired
	private ActivityService activityDAO;

	@Override
	public ServiceRequest createService(ServiceRequest request) {
		request.setSrNumber(generateSRNumber());
		ServiceRequest serviceRequestEntity = this.serviceRequestRepository.save(request);
		Activity activity = new Activity();
//		activity.setSrNumber(serviceRequestEntity.getSrNumber());
		activity.setCreateDate(new Timestamp(System.currentTimeMillis()));
		activity.setUpdate(ActivityEnum.OPEN.toString());
		activity.setServiceRequest(request);
		activityDAO.loggServiceActivity(activity);
		return serviceRequestEntity;
	}

	@Override
	public ServiceRequest editService(ServiceRequest request) {

		ServiceRequest serviceRequestEntity = this.serviceRequestRepository.save(request);
		if (serviceRequestEntity != null) {
			Activity activity = new Activity();
			activity.setServiceRequest(request);
			activity.setCreateDate(new Timestamp(System.currentTimeMillis()));
			activity.setUpdate(ActivityEnum.PROGRESS.toString());
			activityDAO.loggServiceActivity(activity);
		}
		return serviceRequestEntity;
	}

	@Override
	public ServiceRequest getServicesBySrNumber(String srNumber) {
		Optional<ServiceRequest> list = this.serviceRequestRepository.findById(srNumber);
		return list.get();
	}

	@Override
	public Page<ServiceRequest> getAllServices(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return serviceRequestRepository.findAll(pageable);
	}

	/*
	 * @Override public Page<ServiceRequest> findBySpecifications(String specs ,int
	 * page, int size) { Pageable pageable = PageRequest.of(page, size);
	 * SRSpecificationsBuilder builder = new SRSpecificationsBuilder(); String
	 * operationSetExper =
	 * Joiner.on("|").join(SearchOperation.SIMPLE_OPERATION_SET); Pattern pattern =
	 * Pattern.compile("(\\w+?)(" + operationSetExper +
	 * ")(\\p{Punct}?)(\\w+?)(\\p{Punct}?),"); Matcher matcher =
	 * pattern.matcher(specs + ","); while (matcher.find()) {
	 * builder.with(matcher.group(1), matcher.group(2), matcher.group(4),
	 * matcher.group(3), matcher.group(5)); }
	 * 
	 * Specification<ServiceRequest> spec = builder.build(); return
	 * serviceRequestRepository.findAll(spec,pageable); }
	 */

	@Override
	public Page<ServiceRequest> findBySpecifications(Map<String, String> paramMap, int page, int size) {
		String specs = getSpecs(paramMap);
		Pageable pageable = PageRequest.of(page, size);
		SRSpecificationsBuilder builder = new SRSpecificationsBuilder();
		String operationSetExper = Joiner.on("|").join(SearchOperation.SIMPLE_OPERATION_SET);
		Pattern pattern = Pattern.compile("(\\w+?)(" + operationSetExper + ")(\\p{Punct}?)(\\w+?)(\\p{Punct}?),");
		Matcher matcher = pattern.matcher(specs + ",");
		while (matcher.find()) {
			builder.with(matcher.group(1), matcher.group(2), matcher.group(4), matcher.group(3), matcher.group(5));
		}

		Specification<ServiceRequest> spec = builder.build();
		return serviceRequestRepository.findAll(spec, pageable);
	}

	@Override
	public ServiceRequest closeService(ServiceRequest request) {

		ServiceRequest serviceRequestEntity = this.serviceRequestRepository.save(request);
		if (serviceRequestEntity != null) {
			Activity activity = new Activity();
//			activity.setSrNumber(serviceRequestEntity.getSrNumber());
			activity.setServiceRequest(request);
			activity.setCreateDate(new Timestamp(System.currentTimeMillis()));
			activity.setUpdate(ActivityEnum.CLOSED.toString());
			activityDAO.loggServiceActivity(activity);
		}
		return serviceRequestEntity;
	}

	public String generateSRNumber() {

		return RandomStringUtils.randomAlphanumeric(8);
	}

	public String getSpecs(Map<String, String> paramMap) {
		StringBuilder sbr = new StringBuilder("");
		if (paramMap.get("accountId") != null)
			sbr.append(paramMap.get("accountId"));
		if (paramMap.get("fromOpenDate") != null)
			sbr.append(paramMap.get("fromOpenDate"));
		if (paramMap.get("toOpenDate") != null)
			sbr.append(paramMap.get("toOpenDate"));
		if (paramMap.get("fromClosedDate") != null)
			sbr.append(paramMap.get("fromClosedDate"));
		if (paramMap.get("toClosedDate") != null)
			sbr.append(paramMap.get("toClosedDate"));
		if (paramMap.get("status") != null)
			sbr.append(paramMap.get("status"));
		return sbr.toString();
	}

}
