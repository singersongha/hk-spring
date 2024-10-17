package com.example.bank.global;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JwtUtilsTest {

    @Test
    void generateToken() {
        JwtUtils jwtUtils = new JwtUtils(1000*60, "asdfaerrwesdfserw2asdfaerrwesdfserw2321");
        String token = jwtUtils.generateToken("hello");
        System.out.println(token);
    }
}