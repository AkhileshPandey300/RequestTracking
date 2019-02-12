package com.pramati.customerrequest.service.test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.pramati.customerrequest.pojo.Activity;
import com.pramati.customerrequest.pojo.ServiceRequest;
import com.pramati.customerrequest.repository.ActivityRepository;
import com.pramati.customerrequest.service.ActivityServiceImpl;

class ActivityServiceImplTest {

	@InjectMocks
	ActivityServiceImpl activityServiceImpl;

	@Mock
	ActivityRepository activityRepository;

	Activity activity;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
//		"srNumber": "I8jm3Cac",
		ServiceRequest sr = new ServiceRequest();
		sr.setSrNumber("I8jm3Cac");
		activity = new Activity();
		activity.setActId((long) 1);
		activity.setCreatedAt(new Date("2019-02-12T05:56:14.146Z"));
		activity.setCreateDate(new Date("2019-02-12T05:56:14.146Z"));
		activity.setCreatedBy("SYS_ADMIN");
		activity.setServiceRequest(sr);
		activity.setUpdate("");
		activity.setUpdatedAt(new Date("2019-02-12T05:56:14.146Z"));
		activity.setUpdatedBy("SYS_ADMIN");
	}

	@Test
	void testLoggServiceActivity() {

		Activity resultActivity = (Activity) when(activityRepository.save(activity)).thenReturn(activity);

		assertNotNull(resultActivity);

	}

}
