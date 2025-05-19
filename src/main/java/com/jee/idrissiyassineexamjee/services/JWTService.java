package com.jee.idrissiyassineexamjee.services;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

/**
 * Author: Lenovo
 * Created: 5/19/2025
 */
public interface JWTService {
    String extractUsername(String token);

    String generateToken(UserDetails userDetails);

    boolean isTokenValid(String token , UserDetails userDetails);

    String generateRefreshToken(Map<String , Object> extraClaims , UserDetails userDetails);
}
