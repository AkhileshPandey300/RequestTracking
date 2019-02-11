package com.pramati.customerrequest.service.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.pramati.customerrequest.repository.ActivityRepository;
import com.pramati.customerrequest.service.ActivityServiceImpl;

class ActivityServiceImplTest {

	@InjectMocks
	ActivityServiceImpl activityServiceImpl;

	@Mock
	ActivityRepository activityRepository;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testLoggServiceActivity() {
		
	}

}
