package com.pramati.customerrequest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pramati.customerrequest.pojo.User;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
