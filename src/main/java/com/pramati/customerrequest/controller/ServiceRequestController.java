package com.pramati.customerrequest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pramati.customerrequest.pojo.ServiceRequest;
import com.pramati.customerrequest.service.ServiceRequestService;

@RestController
@RequestMapping("/serviceRequest")
public class ServiceRequestController {

	@Autowired
	private ServiceRequestService sRequestRervice;

	@PostMapping("/add")
	public void createService(@Valid @RequestBody ServiceRequest serviceRequest) {
		this.sRequestRervice.createService(serviceRequest);

	}

	@GetMapping("/view/{srnumber}")
	public ServiceRequest getRequest(@PathVariable(value = "srnumber") String srNumber) {
		return this.sRequestRervice.getServicesBySrNumber(srNumber);

	}

	@PutMapping("/update/{srnumber}")
	public ServiceRequest updateServiceRequest(@Valid @RequestBody ServiceRequest serviceRequest) {

		return this.sRequestRervice.editService(serviceRequest);

	}

	@GetMapping("/getAll/{specs}")
	public List<ServiceRequest> getSpecificServices(@PathVariable(value = "specs") String specs) {
		return this.sRequestRervice.findBySpecifications(specs);

	}

	@GetMapping("/getAll/")
	public List<ServiceRequest> getAllServices() {
		return this.sRequestRervice.getAllServices();

	}
	
	@PutMapping("/update/{srnumber}")
	public ServiceRequest closeServiceRequest(@Valid @RequestBody ServiceRequest serviceRequest) {

		return this.sRequestRervice.closeService(serviceRequest);

	}


}
