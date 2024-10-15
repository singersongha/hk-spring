package com.example.jpatest.user.service;

import com.example.jpatest.user.domain.User;
import com.example.jpatest.user.repository.UserRepository;
import com.example.jpatest.user.request.UserRequest;
import com.example.jpatest.user.response.UserResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserServiceTest {

    @Test
    void createUser() {
        userService.createUser()
    }

    @Test
    void updateUser() {
        User user = users.get(0);
        UserRequest userRequest = new UserRequest(user.getEmail(),
                user.getPassword() + "1231",
                user.getUsername());
        UserResponse userResponse = userService.updateUser(user.getId(), userRequest);

        assertNotNull(userResponse);

        User after = userRepository.findById(user.getId()).get();
        assertEquals(userRequest.password(), after.getPassword());
        assertEquals(userRequest.username(), after.getUsername());
        assertEquals(userRequest.email(), after.getEmail());
        assertEquals(user.getEmail(), userResponse.email());
    }

    @Test
    void deleteUserById() {
        userService.deleteUserById(1L);

        assertFalse(userRepository.findById(1L).isPresent());
    }

    @Nested
    class GetUserById{
        @Test
        @DisplayName("성공")
        void getUserById() {
            Long id = users.get(0).getId();

            UserResponse userById = userService.getUserById(id);

            assertNotNull(userById);
            assertEquals(id, userById.id());
            assertEquals(users.get(0).getEmail(), userById.email());
        }
        @Test
        @DisplayName("실패: 못 찾는 경우 NoSuchElementException 발생")
        void getUserById_failure_not_found() {
            Long id = 123123L;

            assertThrows(NoSuchElementException.class,
                    () -> userService.getUserById(id));

        }
    }

    @Test
    void getAllUsers() {

        List<UserResponse> allUsers = userService.getAllUsers();

        assertEquals(10, allUsers.size());
        assertEquals(users.get(0).getId(), allUsers.get(0).id());
    }


    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    String email = "www@naver.com";
    String password = "1234";
    String username = "admin";
    List<User> users;

    @BeforeEach
    void setUp() {
        userService = new UserServiceImpl(userRepository);
        users = new ArrayList<>(); // 리스트로 초기화
        for (int i = 0; i < 10; i++) {
            User user = User.builder()
                    .password(password)
                    .username(username + i)
                    .email(email + i)
                    .build();
            users.add(user);
        }
        userRepository.saveAll(users);
    }
}