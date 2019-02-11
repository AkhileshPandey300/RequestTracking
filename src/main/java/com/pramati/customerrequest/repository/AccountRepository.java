package com.pramati.customerrequest.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pramati.customerrequest.pojo.Account;

@Repository
public interface AccountRepository extends  JpaRepository<Account, Long> {

	List<Account> findByFirstNameAndLastName(String firstName, String LastNAme ,Pageable pageable);

}
