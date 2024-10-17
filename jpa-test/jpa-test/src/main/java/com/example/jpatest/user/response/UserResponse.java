package com.example.jpatest.user.response;

import com.example.jpatest.dto.StoreDto;
import com.example.jpatest.store.domain.Store;
import com.example.jpatest.store.response.StoreResponse;
import com.example.jpatest.user.domain.User;

import java.util.List;

public record UserResponse(
        Long id,
        String email,
        String username,
        List<StoreDto> stores
) {
    public static UserResponse from(User user){
        List<StoreDto> list = user.getStores().stream().map(StoreDto::from).toList();
        return new UserResponse(user.getId(), user.getEmail(), user.getUsername(), list);
    }

}
