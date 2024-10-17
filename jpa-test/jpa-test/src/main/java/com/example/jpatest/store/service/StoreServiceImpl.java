package com.example.jpatest.store.service;

import com.example.jpatest.store.domain.Store;
import com.example.jpatest.store.repository.StoreRepository;
import com.example.jpatest.store.request.StoreRequest;
import com.example.jpatest.store.response.StoreResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {
    private final StoreRepository storeRepository;

    @Override
    public StoreResponse saveStore(StoreRequest storeRequest) {
        Store entity = storeRequest.toEntity();
        storeRepository.save(entity);
        return StoreResponse.from(entity);
    }

    @Override
    public List<StoreResponse> getAllStore() {
        return storeRepository.findAll()
                .stream()
                .map(StoreResponse::from)
                .toList();
    }
}
