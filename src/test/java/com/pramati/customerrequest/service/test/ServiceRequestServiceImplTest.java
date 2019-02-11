package com.pramati.customerrequest.service.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.pramati.customerrequest.exception.AccountNotFoundException;
import com.pramati.customerrequest.pojo.ServiceRequest;
import com.pramati.customerrequest.repository.ServiceRequestRepository;
import com.pramati.customerrequest.service.ServiceRequestServiceImpl;
import com.pramati.customerrequest.utils.ActivityEnum;

class ServiceRequestServiceImplTest {

	@InjectMocks
	ServiceRequestServiceImpl serviceRequestServiceImpl;

	@Mock
	ServiceRequestRepository serviceRequestRepository;

	ServiceRequest rs;

	@BeforeEach
	void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);
		rs.setAccountId(1);
		rs.setActivityList(null);
		rs.setCloseDate(null);
		rs.setContactId(1);
		rs.setCreatedAt(null);
		rs.setCreatedBy("");
		rs.setDescription("Resolve asap");
		rs.setOpenDate(null);
		rs.setSrNumber(RandomStringUtils.randomAlphanumeric(8));
		rs.setStatus(ActivityEnum.OPEN.toString());
		rs.setTitle("System Issue");
		rs.setUpdatedAt(null);
		rs.setUpdatedBy("");
	}

	@Test
	void testCreateService() {
		ServiceRequest service = serviceRequestRepository.save(rs);
		assertNotNull(service);
		assertEquals(rs.getAccountId(), service.getAccountId());
		assertEquals(rs.getCreatedAt(), service.getCreatedAt());
	}

	@Test
	void testEditService() {
		rs.setTitle("Edited");
		ServiceRequest service = serviceRequestRepository.save(rs);
		assertNotNull(service);
		assertEquals(rs.getAccountId(), service.getAccountId());
		assertEquals(rs.getTitle(), service.getTitle());
	}

	@Test
	void testGetServicesBySrNumber() {
		when(serviceRequestRepository.findById(Mockito.anyString())).thenReturn(null);
		Assertions.assertThrows(AccountNotFoundException.class,

				() -> {
					serviceRequestServiceImpl.getServicesBySrNumber("");
				});
	}

	@Test
	void testGetAllServices() {
		List<ServiceRequest> listSR = new ArrayList<>();
		listSR.add(rs);
		Pageable page = PageRequest.of(0, 5);
		Page<ServiceRequest> resultList = (Page<ServiceRequest>) when(serviceRequestRepository.findAll(page))
				.thenReturn((Page<ServiceRequest>) listSR);

		assertNotNull(resultList);
		assertThat(listSR.size() == resultList.getSize());

	}

	@Test
	void testFindBySpecifications() {
	}

	@Test
	void testCloseService() {
	}

}
