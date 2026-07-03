package org.example.taskmanager.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class JwtService {
    private final String SECRET = "mySuperSecretKeyForJwtAuthentication2026";

    public String generateJwtToken(String userName){
        return Jwts.builder()
                .setSubject(userName)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(Keys.hmacShaKeyFor(SECRET.getBytes()))
                .setAudience("taskManager")
                .compact();
    }
    public String extractUserName(String token){
        return Jwts.parserBuilder()
                .setSigningKey(SECRET.getBytes())
                .build()
                .parseClaimsJwt(token)
                .getBody()
                .getSubject();
    }
}
