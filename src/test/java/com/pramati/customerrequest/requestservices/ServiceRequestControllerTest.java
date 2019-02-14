package com.pramati.customerrequest.requestservices;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.pramati.customerrequest.controller.ServiceRequestController;
import com.pramati.customerrequest.service.ServiceRequestService;

class ServiceRequestControllerTest {

	@InjectMocks
	ServiceRequestController serviceRequestController;

	@Mock
	ServiceRequestService serviceRequestService;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testCreateService() {
		
	}

	@Test
	void testGetRequest() {
		
	}

	@Test
	void testUpdateServiceRequest() {
		
	}

	@Test
	void testGetSpecificServices() {
		
	}

	@Test
	void testGetAllServices() {
		
	}

	@Test
	void testCloseServiceRequest() {
		
	}

}
