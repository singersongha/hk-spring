package com.example.jpatest.user.domain;

import ch.qos.logback.core.util.StringUtil;
import com.example.jpatest.config.BaseEntity;
import com.example.jpatest.store.domain.Store;
import com.example.jpatest.user.request.UserRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
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
public class User extends BaseEntity {

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
    // fetch = FetchType.EAGER
    // fetch = FetchType.LAZY default
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    @Builder.Default
    private List<Store> stores = new ArrayList<>();

    //  필드를 갖지만 완벽히 종속된 것은 아닌
    //  User, store, orders의 생성 시간
    //  다른 곳에서도 가질 수 있게 하는 거(상속)

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();


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

