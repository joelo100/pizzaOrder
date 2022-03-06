package com.joe.pizzaorderservice.security;

import io.jsonwebtoken.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;

@Component
public class JwtProvider {
    @Value("${jwt.secret}")
    private String jwtSecret;

    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
    Logger logger = LogManager.getLogger(JwtProvider.class);


    public String generateToken(Authentication authentication) {
        logger.info("secret key = " + jwtSecret);
        String encodedSecret = Base64.getEncoder().encodeToString(jwtSecret.getBytes());
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        Date now = new Date();
        Date expiryDate = new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000);

        return Jwts.builder()
                .setSubject(userPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, encodedSecret)
                .compact();
    }
    public String getUserUsernameFromJWT(String token) {

        Claims claims = Jwts.parser()
                .setSigningKey(Base64.getEncoder().encodeToString(jwtSecret.getBytes()))
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }
    public boolean validateToken(String authToken) {
        try {

            Jwts.parser()
                    .setSigningKey(Base64.getEncoder().encodeToString(jwtSecret.getBytes()))
                    .parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
            logger.error("MalformedJwtException thrown: " + ex);
        } catch (ExpiredJwtException ex) {
            logger.error("ExpiredJwtException thrown: " + ex);
        } catch (UnsupportedJwtException ex) {
            logger.error("UnsupportedJwtException thrown: " + ex);
        } catch (IllegalArgumentException ex) {
            logger.error("IllegalArgumentException thrown: " + ex);
        }
        return false;
    }
}
