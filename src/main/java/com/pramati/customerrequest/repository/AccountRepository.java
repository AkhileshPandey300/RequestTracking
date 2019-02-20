package com.pramati.customerrequest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pramati.customerrequest.pojo.Account;

@Repository
public interface AccountRepository extends  JpaRepository<Account, Long> {

	Page<Account> findByFirstNameAndLastName(String firstName, String LastNAme ,Pageable pageable);
	
	Account findByFirstName(String name);

}
