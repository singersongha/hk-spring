package com.example.jpatest.dto;

import com.example.jpatest.store.response.StoreResponse;
import com.example.jpatest.user.domain.User;

import java.util.List;

public record UserDto(
        Long id,
        String email,
        String username
) {
    public static UserDto from(User user){
        return new UserDto(
                user.getId(),
                user.getEmail(),
                user.getUsername());
    }

}
