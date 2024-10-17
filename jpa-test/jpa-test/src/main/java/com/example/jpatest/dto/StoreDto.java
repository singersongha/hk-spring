package com.example.jpatest.dto;

import com.example.jpatest.store.domain.Store;
import com.example.jpatest.user.response.UserResponse;

public record StoreDto(
        Long id,
        String name,
        String address
) {
    public static StoreDto from(Store store){
        return new StoreDto(
                store.getId(),
                store.getName(),
                store.getAddress()
        );
    }
}
