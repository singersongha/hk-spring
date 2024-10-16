package com.example.jpatest.store.service;

import com.example.jpatest.store.request.StoreRequest;
import com.example.jpatest.store.response.StoreResponse;

import java.util.List;

public interface StoreService {
    StoreResponse saveStore(StoreRequest storeRequest);
    List<StoreResponse> getAllStore();
}
