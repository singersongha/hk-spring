package com.example.jpatest.user.service;

import com.example.jpatest.user.domain.User;
import com.example.jpatest.user.repository.UserRepository;
import com.example.jpatest.user.request.UserRequest;
import com.example.jpatest.user.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public UserResponse createUser(UserRequest userRequest) {
        User entity =  userRequest.toEntity();
        return UserResponse.from(userRepository.save(entity));
    }

    @Override
    public UserResponse updateUser(Long id, UserRequest request) {
        User user = userRepository.findById(id).orElseThrow();
//        user.setPassword(request.password());
//        user.setUsername(request.username());
        user.update(request);
        return UserResponse.from(user);

    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserResponse getUserById(Long id) {

        User user = userRepository.findById(id).orElseThrow();
        return UserResponse.from(user);
    }

    @Override
    public List<UserResponse> getAllUsers() {

        return userRepository.findAll()
                .stream()
                .map(UserResponse::from)
                .toList();
    }

    @Override
    public Page<UserResponse> pageUsers(Pageable request) {
        return userRepository.findAll(request).map(UserResponse::from);
    }
}
