package com.pramati.customerrequest.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;

import com.pramati.customerrequest.pojo.Account;
import com.pramati.customerrequest.pojo.Activity;
import com.pramati.customerrequest.pojo.ServiceRequest;
import com.pramati.customerrequest.repository.ActivityRepository;
import com.pramati.customerrequest.service.ActivityServiceImpl;
import com.pramati.customerrequest.utils.DateConvertor;

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
		activity.setCreatedAt(DateConvertor.convertStringToTimestamp("2019-02-12 00:45:00"));
		activity.setCreateDate(DateConvertor.convertStringToTimestamp("2019-02-12 00:45:00"));
		activity.setCreatedBy("SYS_ADMIN");
		activity.setServiceRequest(sr);
		activity.setUpdate("");
		activity.setUpdatedAt(DateConvertor.convertStringToTimestamp("2019-02-12 00:45:00"));
		activity.setUpdatedBy("SYS_ADMIN");
	}

	@Test
	void testLoggServiceActivity() {
		when(activityRepository.save(activity)).thenReturn(activity);
		Activity resultActivity = activityServiceImpl.loggServiceActivity(activity);
		assertNotNull(resultActivity);
		assertEquals(activity.getActId(), resultActivity.getActId());
		assertEquals(activity.getServiceRequest().getSrNumber(), resultActivity.getServiceRequest().getSrNumber());
	}

}
