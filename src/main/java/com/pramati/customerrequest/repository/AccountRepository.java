package com.pramati.customerrequest.repository;

import org.springframework.stereotype.Repository;

import com.pramati.customerrequest.pojo.Account;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

}
