package com.pramati.customerrequest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pramati.customerrequest.pojo.Activity;
import com.pramati.customerrequest.service.ActivityService;

@RestController
@RequestMapping("/activity")
public class ActivityController {

	@Autowired
	private ActivityService activityService;

	@PostMapping("")
	public void addContact(@Valid @RequestBody Activity activity) {

		activityService.loggServiceActivity(activity);
	}

}
