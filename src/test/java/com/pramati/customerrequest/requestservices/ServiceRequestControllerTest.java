package com.pramati.customerrequest.requestservices;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.pramati.customerrequest.controller.AccountController;
import com.pramati.customerrequest.controller.ServiceRequestController;
import com.pramati.customerrequest.service.AccountService;
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
		fail("Not yet implemented");
	}

	@Test
	void testGetRequest() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateServiceRequest() {
		fail("Not yet implemented");
	}

	@Test
	void testGetSpecificServices() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllServices() {
		fail("Not yet implemented");
	}

	@Test
	void testCloseServiceRequest() {
		fail("Not yet implemented");
	}

}
