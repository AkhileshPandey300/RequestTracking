package com.pramati.customerrequest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pramati.customerrequest.dao.ActivityDAO;
import com.pramati.customerrequest.pojo.Activity;

@Service
public class ActivityServiceImpl implements ActivityService{
	
	@Autowired
	private ActivityDAO activityDAO;

	@Override
	public void loggServiceActivity(Activity activity) {

		this.activityDAO.loggServiceActivity(activity);
	}

}
