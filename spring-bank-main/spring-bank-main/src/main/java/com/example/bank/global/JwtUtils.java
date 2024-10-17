package com.example.bank.global;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

public class JwtUtils {
    // generate token -> username 가져와서 token 생성
    public String generateToken(String username) {
        long expiration = 30000;
        Date expirationDate = new Date(System.currentTimeMillis() + expiration);
        String secret = "asdfaerrwesdfserw2asdfaerrwesdfserw2321";
        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());
        return Jwts.builder()
                .subject(username)
                .expiration(expirationDate)
                .signWith(key)
                .compact();
    }
    // parsetoken -> 토큰 가져와서 username
    public String parseToken(String token) {
        String secret = "asdfaerrwesdfserw2asdfaerrwesdfserw2321";
        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());
        Claims payload = (Claims) Jwts.parser()
                .verifyWith(key)
                .build()
                .parse(token)
                .getPayload();
        return payload.getSubject();
    }
}
