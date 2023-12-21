package com.gcart.gcartbooking.controller;

import com.gcart.gcartbooking.entity.User;
import com.gcart.gcartbooking.service.UserService;
import com.gcart.gcartbooking.pojo.UserPojo;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(value = "/save")
    public String saveUser(@Valid @RequestBody UserPojo userPojo) {
        userService.save(userPojo);
        return "Saved Successfully!";
    }

    @GetMapping("/getAll")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Optional<User> getById(@PathVariable("id") Long id) {
        return userService.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Long id, @Valid @RequestBody UserPojo userPojo) {
        return userService.update(id, userPojo);
    }

    @GetMapping("/getByEmail/{email}")
    public Optional<User> getByEmail(@PathVariable("email") String email) {
        return userService.getByEmail(email);
    }
}
