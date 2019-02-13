package com.pramati.customerrequest.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.pramati.customerrequest.exception.ServicerRequestNotFoundException;
import com.pramati.customerrequest.pojo.Activity;
import com.pramati.customerrequest.pojo.ServiceRequest;
import com.pramati.customerrequest.service.ActivityService;
import com.pramati.customerrequest.service.ServiceRequestService;

@RestController
@RequestMapping("/servicerequests")
public class ServiceRequestController {

	@Autowired
	private ServiceRequestService sRequestRervice;
	@Autowired
	private ActivityService activityService;

	@PostMapping("/")
	public ServiceRequest createService(@Valid @RequestBody ServiceRequest serviceRequest) {
		serviceRequest.getAccountId();

		return this.sRequestRervice.createService(serviceRequest);
	}

	@GetMapping("/{srnumber}")
	public ServiceRequest getRequest(@PathVariable(value = "srnumber") String srNumber)
			throws ServicerRequestNotFoundException {
		return this.sRequestRervice.getServicesBySrNumber(srNumber);

	}

	@PutMapping("/{srnumber}")
	public ServiceRequest updateServiceRequest(@PathVariable(value = "srnumber") String srNumber,
			@Valid @RequestBody ServiceRequest serviceRequest) throws ServicerRequestNotFoundException {

		serviceRequest.setSrNumber(srNumber);
		return this.sRequestRervice.editService(serviceRequest);

	}

	@GetMapping("/{specs}")
	public Page<ServiceRequest> getSpecificServices(@RequestParam(value = "serach", required = false) String specs,
			@RequestParam("page") int page, @RequestParam("size") int size) {
		Page<ServiceRequest> servicePage = this.sRequestRervice.findBySpecifications(specs, page, size);
		return servicePage;

	}

	@GetMapping("/")
	public Page<ServiceRequest> getAllServices(@RequestParam("page") int page, @RequestParam("size") int size) {
		return this.sRequestRervice.getAllServices(page, size);
	}

	@PostMapping("/activity")
	public Activity loggingActivity(@Valid @RequestBody Activity activity) {

		return this.activityService.loggServiceActivity(activity);

	}

}