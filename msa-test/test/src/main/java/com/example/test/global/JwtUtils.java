package com.example.test.global;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtils {

    private final long expiration;
    private final SecretKey key;

    // application.yml에서 변수 가져오는 법
    public JwtUtils(
            @Value("${jwt.expiration}") long expiration,
            @Value("${jwt.secret}") String secret) {
        System.out.println(expiration);
        this.expiration = expiration;
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    // generate token -> username 가져와서 token 생성
    public String generateToken(String username) {
        Date expirationDate = new Date(System.currentTimeMillis() + expiration);

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
