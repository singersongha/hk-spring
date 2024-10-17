package com.example.bank.global;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class JwtUtilsTest2 {
    @Value("${jwt.secret}")
    String secret;
    @Test
    void test(){
        assertEquals("asdfaerrwesdfserw2asdfaerrwesdfserw2321", secret);
    }

}