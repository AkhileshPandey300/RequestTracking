package com.pramati.customerrequest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pramati.customerrequest.pojo.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

}
