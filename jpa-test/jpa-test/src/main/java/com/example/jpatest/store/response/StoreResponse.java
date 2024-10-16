package com.example.jpatest.store.response;

import com.example.jpatest.store.domain.Store;
import com.example.jpatest.user.response.UserResponse;

public record StoreResponse(
        Long id,
        String name,
        String address,
        UserResponse user
) {
    public static StoreResponse from(Store store){
        return new StoreResponse(
                store.getId(), store.getName(), store.getAddress(), UserResponse.from(store.getUser())
        );
    }
}
