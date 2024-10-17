package com.example.jpatest.user.controller;

import com.example.jpatest.user.request.UserRequest;
import com.example.jpatest.user.response.UserResponse;
import com.example.jpatest.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/api/v1/users")
    public UserResponse save(
            @RequestBody UserRequest request
    ){
        return userService.createUser(request);
    }

    @GetMapping("/api/v1/users")
    public List<UserResponse> getAll() {

        return userService.getAllUsers();
    }

    @GetMapping("/api/v1/users/page")
    public Page<UserResponse> getPage(
            @PageableDefault(size = 10) Pageable request
            ){
        return userService.pageUsers(request);
    }

}

