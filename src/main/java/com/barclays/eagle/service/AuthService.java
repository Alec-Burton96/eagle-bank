package com.barclays.eagle.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@ConfigurationProperties(prefix = "auth.jwt")
public class AuthService {

    @Value("${auth.jwt.username}")
    private String username;
    @Value("${auth.jwt.password}")
    private String password;
    @Value("${auth.jwt.signingKey}")
    private String signingKey;
    @Value("${auth.jwt.timeout}")
    private int timeout;

    public boolean isAuthenticated(String username, String password) {
        return username.equals(this.username) && password.equals(this.password);
    }

    public String generateJwtToken(String username) {

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + this.timeout))
                .signWith(Keys.hmacShaKeyFor(this.signingKey.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(this.signingKey.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}


