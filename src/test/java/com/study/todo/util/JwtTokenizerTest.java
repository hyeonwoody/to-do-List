package com.study.todo.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sound.midi.Soundbank;
import java.nio.charset.StandardCharsets;
import java.sql.SQLOutput;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class JwtTokenizerTest {

    @Value("${jwt.secretKey}") //application.properties의 jwt.secretKey 값
    String accessSecret;

    public final Long ACCESS_TOKEN_EXPIRE_COUNT =30 * 60 * 1000L;

    String jwtToken="";
    @Test
    public void createToken () throws Exception {
        String email = "hyeonwoody@gmail.com";
        List<String> roles = List.of ("ROLE_USER");
        Long id = 1L;
        String password = "daa";
        Claims claims = Jwts.claims().setSubject(email);

        claims.put ("roles", roles);
        claims.put ("userId", id);
        claims.put ("password", password);


        byte[] key =this.accessSecret.getBytes(StandardCharsets.UTF_8);

        System.out.println(accessSecret);

        this.jwtToken = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + this.ACCESS_TOKEN_EXPIRE_COUNT))
                .signWith((Keys.hmacShaKeyFor(key)))
                .compact();

        System.out.println(this.jwtToken);
    }

    @Test
    public void parseToken() throws Exception{
        createToken();
        //this.jwtToken = "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJoeWVvbndvb2R5QGdtYWlsLmNvbSIsInJvbGVzIjpbIlJPTEVfVVNhYWFhYWFhYWFSIl0sInVzZXJJZCI6MSwicGFzc3dvcmQiOiJkYWEiLCJpYXQiOjE2ODIyNDkyODksImV4cCI6MTY4MjI1MTA4OX0.Wnql-REYMfKhAzduxcL7jF40oXK99bfGWydV9dMFrDq9esLFEvDuD-KoopF_teBu";
        byte[] accessSecret = this.accessSecret.getBytes(StandardCharsets.UTF_8);
        Claims claims = Jwts.parserBuilder() //jwtParserBuilder 반환.
                .setSigningKey(Keys.hmacShaKeyFor(accessSecret))
                .build()
                .parseClaimsJws(this.jwtToken)
                .getBody();
        System.out.println(claims.getSubject());
        System.out.println(claims.get("roles"));
        System.out.println(claims.get("userId"));
        System.out.println(claims.getIssuedAt());
        System.out.println(claims.getExpiration());
    }
}
