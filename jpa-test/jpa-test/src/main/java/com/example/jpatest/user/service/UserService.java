package com.example.jpatest.user.service;

import com.example.jpatest.user.request.UserRequest;
import com.example.jpatest.user.response.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    UserResponse createUser(UserRequest userRequest);
    UserResponse updateUser(Long id, UserRequest request);
    void deleteUserById(Long id);
    UserResponse getUserById(Long id);
    List<UserResponse> getAllUsers();
    Page<UserResponse> pageUsers(Pageable request);
}
