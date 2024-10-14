package com.example.springdb.store;

import org.springframework.data.jpa.repository.JpaRepository;

// 추상적으로 구현
// 데이터베이스와 맞닿는 곳 : repository
public interface StoreRepository
    extends JpaRepository<Store, Long> {

}
