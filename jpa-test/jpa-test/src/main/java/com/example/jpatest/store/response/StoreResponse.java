package com.example.jpatest.store.response;

import com.example.jpatest.dto.UserDto;
import com.example.jpatest.store.domain.Store;
import com.example.jpatest.user.response.UserResponse;

public record StoreResponse(
        Long id,
        String name,
        String address,
        UserDto user
) {
    public static StoreResponse from(Store store){
        // 알고리즘 dfs (재귀)
//      자료구조 stack
        return new StoreResponse(
                store.getId(),
                store.getName(),
                store.getAddress(),
                UserDto.from(store.getUser())
        );
    }

}

