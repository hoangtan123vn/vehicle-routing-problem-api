package com.personal.vrpapi.core.authorization.service;

import com.personal.vrpapi.core.base.entity.AbstractUser;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface JwtTokenService {
    /**
     * generate token base on List<GrantedAuthority>
     * @param userDetails
     * @return
     */
    String generateToken(UserDetails userDetails);

    /**
     * validate Token on authToken request
     * @param authToken
     * @return
     */
    Boolean validateToken(String authToken);

    /**
     * if JwtToken is valid, get Username from jwt token
     * @param token
     * @return
     */
    String getUserNameFromJwtToken(String token);

    /**
     * get current user on session
     * @return
     */
    AbstractUser getCurrentUser();

    /**
     * when token is valid -> initialize roles from token when authentication token
     * @param authToken
     * @return
     */
    List<SimpleGrantedAuthority> getRolesFromToken(String authToken);
}
