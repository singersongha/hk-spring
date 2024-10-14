package com.example.springdb.store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// 추상적으로 구현
// 데이터베이스와 맞닿는 곳 : repository


public interface StoreRepository
    extends JpaRepository<Store, Long> {
//    select * from tbl where name like "%?%"
    List<Store> findByNameContainingOrderByIdDesc(String name);
//    JPQL
//    SELECT * FROM classname as s(as 생략가능)
    @Query("SELECT s FROM Store s WHERE s.name LIKE %?1%")
    List<Store> findByNameContain(String name);
//   이름으로 삭제
    @Transactional
    @Modifying
    @Query("DELETE FROM Store s WHERE s.name = ?1")
    void deleteByNameContain(String name);

//    아이디가 5 이상의 것들 출력
    @Query("SELECT s FROM Store s WHERE s.id >= ?5")
    List<Store> findByIdGreaterThan(int id);
//    name, address 둘 중 하나라도 들어가있는 것 출력
//    @Query("SELECT s FROM Store s WHERE s.name = ?1 or s.address = ?2")
}
