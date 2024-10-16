package com.example.jpatest.store.request;

import com.example.jpatest.store.domain.Store;
import com.example.jpatest.user.domain.User;

import java.util.ArrayList;

public record StoreRequest(
        String name,
        String address,
        Long userId
) {
    public Store toEntity() {
        User user = User.builder().id(userId).build();
        return new Store(null, name, address, user, new ArrayList<>());
    }
}
