package com.personal.vrpapi.core.authorization.service;

import com.personal.vrpapi.core.authorization.entity.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface JwtTokenService {
    String generateToken(UserDetails userDetails);

    Boolean validateToken(String authToken);

    String getUserNameFromJwtToken(String token);

    User getCurrentUser();

    List<SimpleGrantedAuthority> getRolesFromToken(String authToken);
}
