package com.gcart.gcartbooking.service.impl;

import com.gcart.gcartbooking.entity.User;
import com.gcart.gcartbooking.pojo.UserPojo;
import com.gcart.gcartbooking.repo.UserRepo;
import com.gcart.gcartbooking.service.UserService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public String save(UserPojo userPojo) {
        User user;

        if (userPojo.getUserId() != null) {
            user = userRepo.findById(userPojo.getUserId())
                    .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + userPojo.getUserId()));
        } else {
            user = new User();
        }

        // Set values from UserPojo to User entity
        user.setUsername(userPojo.getUsername());
        user.setPassword(userPojo.getPassword());
        user.setEmail(userPojo.getEmail());
        user.setMobileNo(userPojo.getMobileNo());
        user.setRole(userPojo.getRole());
        user.setFullName(userPojo.getFullName());
        user.setDateJoined(LocalDate.now());

        userRepo.save(user);
        return "Saved Successfully!";
    }

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public Optional<User> getById(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public String update(Long id, UserPojo userPojo) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + id));

        // Set values from UserPojo to User entity for update
        user.setUsername(userPojo.getUsername());
        user.setPassword(userPojo.getPassword());
        user.setEmail(userPojo.getEmail());
        user.setMobileNo(userPojo.getMobileNo());
        user.setRole(userPojo.getRole());
        user.setFullName(userPojo.getFullName());

        userRepo.save(user);
        return "Updated Successfully!";
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    // Other custom service methods, if any
}
