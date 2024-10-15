package com.example.jpatest.user.request;

import com.example.jpatest.user.domain.User;

public record UserRequest(
        String email,
        String password,
        String username
) {
    public User toEntity(){
        return User.builder()
                .email(email)
                .password(password)
                .username(username)
                .build();
    }
}
