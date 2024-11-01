package com.example.bank.user.service;

import com.example.bank.user.request.LoginRequest;
import com.example.bank.user.request.RegisterRequest;
import com.example.bank.user.response.UserResponse;

public interface UserService {
    String login(LoginRequest loginRequest);
    void register(RegisterRequest registerRequest);
    UserResponse getById(String id);
    UserResponse getByToken(String token);
}
