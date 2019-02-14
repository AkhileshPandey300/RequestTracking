package com.pramati.customerrequest.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import com.pramati.customerrequest.exception.ServicerRequestNotFoundException;
import com.pramati.customerrequest.pojo.ServiceRequest;
import com.pramati.customerrequest.repository.ServiceRequestRepository;
import com.pramati.customerrequest.service.ServiceRequestServiceImpl;
import com.pramati.customerrequest.utils.ActivityEnum;
import com.pramati.customerrequest.utils.TestUtils;

class ServiceRequestServiceImplTest {

	@InjectMocks
	ServiceRequestServiceImpl serviceRequestServiceImpl;

	@Mock
	ServiceRequestRepository serviceRequestRepository;

	ServiceRequest rs;

	@BeforeEach
	void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);
		rs = new ServiceRequest();
		rs.setAccountId((long) 1);
		rs.setActivityList(null);
		rs.setCloseDate(null);
		rs.setContactId(1);
		rs.setCreatedAt(null);
		rs.setCreatedBy("");
		rs.setDescription("Resolve asap");
		rs.setOpenDate(null);
		rs.setSrNumber("I8jm3Cac");
		rs.setStatus(ActivityEnum.OPEN.toString());
		rs.setTitle("System Issue");
		rs.setUpdatedAt(null);
		rs.setUpdatedBy("");
	}

	@Test
	void testCreateService() {
		when(serviceRequestRepository.save(rs)).thenReturn(rs);
		ServiceRequest resultServiceRequest = serviceRequestServiceImpl.createService(rs);
		assertNotNull(resultServiceRequest);
		assertEquals(rs.getAccountId(), resultServiceRequest.getAccountId());
		assertEquals(rs.getContactId(), resultServiceRequest.getContactId());
	}

	@Test
	void testEditService() {
		when(serviceRequestRepository.save(rs)).thenReturn(rs);
		Assertions.assertThrows(ServicerRequestNotFoundException.class,

				() -> {
					serviceRequestServiceImpl.editService(rs);
				});
		ServiceRequest resultServiceRequest;
		try {
			resultServiceRequest = serviceRequestServiceImpl.editService(rs);

			assertNotNull(resultServiceRequest);
			assertEquals(rs.getAccountId(), resultServiceRequest.getAccountId());
		} catch (ServicerRequestNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Test
	void testGetServicesBySrNumber() {
		Optional<ServiceRequest> opAcc = Optional.of(rs);
		when(serviceRequestRepository.findById("I8jm3Cac")).thenReturn(opAcc);
		ServiceRequest result;
		try {
			result = serviceRequestServiceImpl.getServicesBySrNumber("I8jm3Cac");
			assertEquals(rs.getAccountId(), result.getAccountId());
		} catch (ServicerRequestNotFoundException e) {
			e.printStackTrace();
		}
		when(serviceRequestRepository.findById("I8jm3Cac")).thenReturn(opAcc);

			Assertions.assertThrows(ServicerRequestNotFoundException.class,

				() -> {
					serviceRequestServiceImpl.getServicesBySrNumber("4awdawq");
				});
	}

	@Test
	void testGetAllServices() {
		List<ServiceRequest> listSR = new ArrayList<>();
		listSR.add(rs);
		Pageable page = PageRequest.of(0, 5);
		when(serviceRequestRepository.findAll()).thenReturn(listSR);
		Page<ServiceRequest> pageResult = serviceRequestServiceImpl.getAllServices(0, 1);
		if (pageResult != null) {
			List<ServiceRequest> listResult = pageResult.getContent();
			assertEquals(1, listResult.size());
		}
	}

	@Test
	void testFindBySpecifications() {
		String specs = "accountId:1,openDate>2019-02-11T19:15:00.000+0000,openDate<2019-02-11T19:15:00.000+0000,closeDate>2019-02-11T19:15:00.000+0000,closeDate<2019-02-11T19:15:00.000+0000,status:OPEN";
		List<ServiceRequest> listServiceRequest = new ArrayList<ServiceRequest>();
		listServiceRequest.add(rs);
		Pageable pageable = PageRequest.of(0, 1);
		Page<ServiceRequest> pageAccount = new PageImpl<>(listServiceRequest);
		when(serviceRequestRepository.findAll(TestUtils.builder(specs), pageable)).thenReturn(pageAccount);
		Page<ServiceRequest> resultPageAccount = serviceRequestServiceImpl.findBySpecifications(specs, 0, 1);
//		assertNotNull(resultPageAccount);
//		List<ServiceRequest> resultAccountList = resultPageAccount.getContent();
//		assertNotNull(resultAccountList);
//		assertTrue(listServiceRequest.size() == resultAccountList.size());
	}

	@Test
	void testCloseService() {
	}
}
