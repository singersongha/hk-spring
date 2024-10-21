package com.example.test;

import com.example.test.global.UserResponse;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;

public class TestController {
    @GetMapping("/api/v1/test")
    public String test() {
        return "김송하";
    }
    @GetMapping("/api/v1/test/1")
    public UserResponse test1(
            @AuthenticationPrincipal UserResponse user
            ) {
        return user;
    }
}
