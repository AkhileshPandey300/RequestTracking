package com.pramati.customerrequest.controller;

import java.util.Map;

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

import com.pramati.customerrequest.pojo.ServiceRequest;
import com.pramati.customerrequest.service.ServiceRequestService;

@RestController
@RequestMapping("/servicerequests")
public class ServiceRequestController {

	@Autowired
	private ServiceRequestService sRequestRervice;

	@PostMapping("/")
	public ServiceRequest createService(@Valid @RequestBody ServiceRequest serviceRequest) {
		serviceRequest.getAccountId();

		return this.sRequestRervice.createService(serviceRequest);

	}

	@GetMapping("/{srnumber}")
	public ServiceRequest getRequest(@PathVariable(value = "srnumber") String srNumber) {
		return this.sRequestRervice.getServicesBySrNumber(srNumber);

	}

	@PutMapping("/{srnumber}")
	public ServiceRequest updateServiceRequest(@PathVariable(value = "srnumber") String srNumber,
			@Valid @RequestBody ServiceRequest serviceRequest) {

		serviceRequest.setSrNumber(srNumber);
		return this.sRequestRervice.editService(serviceRequest);

	}

//	@GetMapping("/getAll/{specs}")
	/*
	 * public Page<ServiceRequest>
	 * getSpecificServices(@RequestParam(value="accountId" ,required=false) int
	 * accountId,
	 * 
	 * @RequestParam(value="fromOpenDate",required=false) Date
	 * fromOpenDate,@RequestParam(value="toOpenDate",required=false) Date
	 * toOpenDate,
	 * 
	 * @RequestParam(value="fromClosedDate",required=false) Date
	 * fromClosedDate,@RequestParam(value ="toClosedDate",required=false) Date
	 * toClosedDate,
	 * 
	 * @RequestParam(value="status",required=false) Date status,
	 * 
	 * @RequestParam("page") int page, @RequestParam("size") int size) { // return
	 * this.sRequestRervice.findBySpecifications(specs, page, size); return
	 * this.sRequestRervice.findBySpecifications(specs, page, size);
	 * 
	 * }
	 */
	@GetMapping("/")
	public Page<ServiceRequest> getSpecificServices(@RequestParam Map<String, String> requestParamsMap,
			@RequestParam("page") int page, @RequestParam("size") int size) {
		return this.sRequestRervice.findBySpecifications(requestParamsMap, page, size);

	}

	@GetMapping("/")
	public Page<ServiceRequest> getAllServices(@RequestParam("page") int page, @RequestParam("size") int size) {
		return this.sRequestRervice.getAllServices(page, size);

	}

}