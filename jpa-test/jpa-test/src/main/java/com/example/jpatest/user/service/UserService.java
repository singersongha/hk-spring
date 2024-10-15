package com.example.jpatest.user.service;

import com.example.jpatest.user.request.UserRequest;
import com.example.jpatest.user.response.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse createUser(UserRequest userRequest);
    UserResponse updateUser(Long id, UserRequest request);
    void deleteUserById(Long id);
    UserResponse getUserById(Long id);
    List<UserResponse> getAllUsers();
}
