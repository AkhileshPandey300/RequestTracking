package com.pramati.customerrequest.controller;

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
		
	}
	
	@GetMapping ("/view/{srnumber}")
	public ServiceRequest getRequest(@PathVariable(value = "srnumber") String srNumber) {
		return null;
		
	}
	
	@PutMapping("/update/{srnumber}")
	public void updateServiceRequest(@PathVariable(value = "srnumber") String srNumber,
			@Valid @RequestBody ServiceRequest serviceRequest) {
		
	}
	
	@GetMapping ("/getAll}")
	public ServiceRequest getAllRequest() {
		return null;
		
	}

}
