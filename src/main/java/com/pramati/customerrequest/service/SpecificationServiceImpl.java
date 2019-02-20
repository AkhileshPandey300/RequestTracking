package com.pramati.customerrequest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pramati.customerrequest.pojo.Specifications;
import com.pramati.customerrequest.repository.SpecificationsRepository;

@Service
public class SpecificationServiceImpl implements SpecificationsService {

	@Autowired
	private SpecificationsRepository specsRepository;

	@Override
	public Specifications createSpecificationTemplate(Specifications specs) {

		return this.specsRepository.save(specs);

	}

}
