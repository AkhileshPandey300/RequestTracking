package com.pramati.customerrequest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pramati.customerrequest.pojo.Contact;
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
