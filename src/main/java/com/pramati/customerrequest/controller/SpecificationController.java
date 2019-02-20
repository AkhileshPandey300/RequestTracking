package com.pramati.customerrequest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pramati.customerrequest.pojo.Specifications;
import com.pramati.customerrequest.service.SpecificationsService;

@RestController
@RequestMapping("/searchtemplate")
public class SpecificationController {

	@Autowired
	private SpecificationsService specsService;

	public void setSpecsService(SpecificationsService specsService) {
		this.specsService = specsService;
	}

	@PostMapping(value = "/")
	public Specifications add(@RequestBody Specifications specs) {
		return this.specsService.createSpecificationTemplate(specs);
	}

}
