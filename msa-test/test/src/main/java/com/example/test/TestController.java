package com.example.test;

import org.springframework.web.bind.annotation.GetMapping;

public class TestController {
    @GetMapping("/api/v1/test")
    public String test() {
        return "김송하";
    }
}
