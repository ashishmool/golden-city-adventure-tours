package com.gcart.gcartbooking.service;

import com.gcart.gcartbooking.entity.User;
import com.gcart.gcartbooking.pojo.UserPojo;

import java.util.List;
import java.util.Optional;

public interface UserService {

    String save(UserPojo userPojo);

    List<User> getAll();

    Optional<User> getByEmail(String email);

    void deleteById(Long id);

    Optional<User> getById(Long id);

    String update(Long id, UserPojo userPojo);
}
