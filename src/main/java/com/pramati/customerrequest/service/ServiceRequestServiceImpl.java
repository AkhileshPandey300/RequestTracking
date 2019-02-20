package com.pramati.customerrequest.service;

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
import com.pramati.customerrequest.exception.ServicerRequestNotFoundException;
import com.pramati.customerrequest.pojo.ServiceRequest;
import com.pramati.customerrequest.pojo.Specifications;
import com.pramati.customerrequest.repository.ServiceRequestRepository;
import com.pramati.customerrequest.repository.SpecificationsRepository;
import com.pramati.customerrequest.utils.ActivityEnum;
import com.pramati.customerrequest.utils.SRSpecificationsBuilder;
import com.pramati.customerrequest.utils.SearchOperation;

@Service
@Transactional
public class ServiceRequestServiceImpl implements ServiceRequestService {

	@Autowired
	private ServiceRequestRepository serviceRequestRepository;

	@Autowired
	private SpecificationsRepository specificationRepository;

	@Override
	public ServiceRequest createService(ServiceRequest request) {
		request.setSrNumber(generateSRNumber());
		request.setStatus(ActivityEnum.OPEN.toString());
		ServiceRequest serviceRequestEntity = this.serviceRequestRepository.save(request);
		return serviceRequestEntity;
	}

	@Override
	public ServiceRequest editService(ServiceRequest request) throws ServicerRequestNotFoundException {
		Optional<ServiceRequest> srOpt = serviceRequestRepository.findById(request.getSrNumber());

		if (!srOpt.isPresent())
			throw new ServicerRequestNotFoundException("Not Found");

		request.setStatus(ActivityEnum.PROGRESS.toString());
		ServiceRequest serviceRequestEntity = this.serviceRequestRepository.save(request);
		return serviceRequestEntity;
	}

	@Override
	public ServiceRequest getServicesBySrNumber(String srNumber) throws ServicerRequestNotFoundException {

		return this.serviceRequestRepository.findById(srNumber)
				.orElseThrow(() -> (new ServicerRequestNotFoundException("SRNumber-" + srNumber)));
	}

	@Override
	public Page<ServiceRequest> getAllServices(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return serviceRequestRepository.findAll(pageable);
	}

	@Override
	public Page<ServiceRequest> findBySpecifications(String specs, int page, int size) {
		
		if(!specs.contains(",")) {
			Specifications specsEntity = specificationRepository.findBySpecsName(specs);
			if (specsEntity != null) {
				specs = specsEntity.getSpecs();
			}			
		}
		StringBuilder sbr = new StringBuilder();
		Pageable pageable = PageRequest.of(page, size);
		SRSpecificationsBuilder builder = new SRSpecificationsBuilder();
		String operationSetExper = Joiner.on("|").join(SearchOperation.SIMPLE_OPERATION_SET);
		Pattern pattern = Pattern
				.compile("(\\w+?)(" + operationSetExper + ")(\\p{Punct}?)([\\w-\\s:]+?)(\\p{Punct}?),");
		Matcher matcher = pattern.matcher(specs + ",");
		while (matcher.find()) {
			builder.with(matcher.group(1), matcher.group(2), matcher.group(4), matcher.group(3), matcher.group(5));
			sbr.append(matcher.group(1)+";");
		}
		Specification<ServiceRequest> spec = builder.build();
		return serviceRequestRepository.findAll(spec, pageable);
	}

	@Override
	public ServiceRequest closeService(ServiceRequest request) {
		request.setStatus(ActivityEnum.CLOSED.toString());
		ServiceRequest serviceRequestEntity = this.serviceRequestRepository.save(request);
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
