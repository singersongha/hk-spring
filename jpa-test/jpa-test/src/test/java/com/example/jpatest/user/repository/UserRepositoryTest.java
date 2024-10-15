package com.example.jpatest.user.repository;

import com.example.jpatest.user.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest // 스프링을 직접 실행해서 테스트 함
//@DataJpaTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("빌더_테스트")
    void builderTest(){
        User user = User.builder()
                .email("dfdf")
                .password("asdf")
                .username("song")
                .build();
        assertEquals(new ArrayList<>(), user.getStores());
        assertEquals("dfdf", user.getEmail());
    }
    @Test
//    @Transactional // 테스트 환경에서 트랜잭션은 무조건 rollback
    void saveTest(){
        // given 이러한 값이 주어지고
        String email = "email";
        String password = "pass";
        String username = "user";

        User user = User.builder().email(email).password(password).username(username).build();

        // when 이거 실행했는데
        userRepository.save(user);


        // then 그 후 이런 값이랑 매칭이 되었다.
        assertEquals(email, user.getEmail());
        assertNotNull(user.getId());
    }
    @Test
    void 다섯개를_저장후_전부가_다섯개가_맞음을_테스트(){

        String email = "email1";
        String password = "pass";
        String username = "user";

        for(int i = 1; i <= 5; i++) {
            User user = User.builder().email(email+i).password(password).username(username).build();
            userRepository.save(user);
        }

        List<User> all = userRepository.findAll();
        assertEquals(5, all.size());
//        assertEquals(email+4, all.get(4).getEmail());

    }

    @Test
    void 이메일_email로_저장후_이메일로_찾아오는_테스트(){

        String email = "email1";
        String password = "pass";
        String username = "user";

        User user = User.builder().email(email).password(password).username(username).build();
        userRepository.save(user);

        Optional<User> byEmail = userRepository.findByEmail(email);

        assertTrue(byEmail.isPresent());
        assertEquals(email, byEmail.get().getEmail());
    }
}