package com.example.jpatest.user.domain;

import ch.qos.logback.core.util.StringUtil;
import com.example.jpatest.store.domain.Store;
import com.example.jpatest.user.request.UserRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
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
@Builder
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
    @Builder.Default
    private List<Store> stores = new ArrayList<>();
    public void update(UserRequest request) {
        if(!StringUtil.isNullOrEmpty(request.password()))
            this.password = request.password();
        if(StringUtil.isNullOrEmpty(request.username()))
            this.username = request.username();


//    public void setPassword(String password) {
//    }
//
//    public void setUsername(String username) {
//
//    }

    }
}

