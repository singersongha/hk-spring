package com.example.jpatest.user.repository;

import com.example.jpatest.user.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository
    extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    @Query("select u from User u join fetch u.stores")
    List<User> findJoinAll();

    //Page<User> findAll(PageRequest request);
    Optional<User> findById(Long id);

//    @Query("")
//    List<User> findJoinAll();
}
