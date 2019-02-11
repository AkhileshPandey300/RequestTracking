package com.pramati.customerrequest.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pramati.customerrequest.pojo.Activity;
import com.pramati.customerrequest.repository.ActivityRepository;

@Service
@Transactional
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private ActivityRepository activityRepository;

	public void setActivityRepository(ActivityRepository activityRepository) {
		this.activityRepository = activityRepository;
	}

	@Override
	public Activity loggServiceActivity(Activity activity) {

		Activity activityEntity = this.activityRepository.save(activity);
		return activityEntity;
	}

}
