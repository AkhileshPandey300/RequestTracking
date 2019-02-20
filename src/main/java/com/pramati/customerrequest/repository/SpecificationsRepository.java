package com.pramati.customerrequest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pramati.customerrequest.pojo.Specifications;
@Repository
public interface SpecificationsRepository extends JpaRepository<Specifications, Integer> {

	public Specifications findBySpecsName(String specs);

}