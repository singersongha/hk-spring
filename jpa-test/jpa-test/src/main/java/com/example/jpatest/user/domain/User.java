package com.example.jpatest.user.domain;

import com.example.jpatest.store.domain.Store;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(
        name = "USERS",
        indexes = {
                @Index(columnList = "email"),
                @Index(columnList = "username")
        }
)
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(length = 10, nullable = false)
    private String username;

//    (1:n)
    @OneToMany(mappedBy = "user")
    private List<Store> stores;
}

