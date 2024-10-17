package com.example.bank.global;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JwtUtilsTest {

    @Test
    void generateToken() {
        JwtUtils jwtUtils = new JwtUtils();
        String token = jwtUtils.generateToken("hello");
        System.out.println(token);
    }

    @Test
    void parseToken() {
        JwtUtils jwtUtils = new JwtUtils();
        String hello = jwtUtils.parseToken("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJoZWxsbyIsImV4cCI6MTcyOTEzOTg4N30.oWHK5NhYqclPgooTS4bhpsutFXENgcXD4Z5nQQZo-Ik");
        System.out.println(hello);
    }
}