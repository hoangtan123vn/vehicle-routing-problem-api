package com.personal.vrpapi.core.authorization.service.impl;

import com.personal.vrpapi.core.authorization.enums.RoleEnum;
import com.personal.vrpapi.core.authorization.repository.AbstractUserRepository;
import com.personal.vrpapi.core.authorization.service.JwtTokenService;
import com.personal.vrpapi.core.base.entity.AbstractUser;
import com.personal.vrpapi.core.base.exception.BaseException;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class JwtTokenServiceImpl implements JwtTokenService {

    private static final Logger logger = LoggerFactory.getLogger(JwtTokenServiceImpl.class);

    @Value("${app.jwtSecret}")
    private String jwtSecret;

    @Value("${app.jwtExpirationInMs}")
    private int jwtExpirationInMs;

    @Resource
    private AbstractUserRepository userRepository;

    @Resource
    private Map<RoleEnum, String> roleEnumMap;

    @Override
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        Collection<? extends GrantedAuthority> roles = userDetails.getAuthorities();
        if (roles.contains(new SimpleGrantedAuthority(RoleEnum.ADMIN.toString()))) {
            claims.put(roleEnumMap.get(RoleEnum.ADMIN), true);
        }
        if (roles.contains(new SimpleGrantedAuthority(RoleEnum.DRIVER.toString()))) {
            claims.put(roleEnumMap.get(RoleEnum.DRIVER), true);
        }
        if (roles.contains(new SimpleGrantedAuthority(RoleEnum.CUSTOMER.toString()))) {
            claims.put(roleEnumMap.get(RoleEnum.CUSTOMER), true);
        }

        return Jwts.builder().setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationInMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    @Override
    public Boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
            logger.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            logger.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            logger.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            logger.error("JWT claims string is empty.");
        }
        return false;
    }

    @Override
    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody().getSubject();
    }

    @Override
    public AbstractUser getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails userDetails) {
            String username = userDetails.getUsername();
            return userRepository.findByUserName(username);
        } else{
            throw new BaseException("User not logged in");
        }
    }

    @Override
    public List<SimpleGrantedAuthority> getRolesFromToken(String authToken) {
        List<SimpleGrantedAuthority> roles = Collections.emptyList();
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken).getBody();
        Boolean isAdmin = claims.get("isAdmin", Boolean.class);
        Boolean isDriver = claims.get("isDriver", Boolean.class);
        Boolean isCustomer = claims.get("isCustomer", Boolean.class);
        if (isAdmin != null && isAdmin) {
            return List.of(new SimpleGrantedAuthority(RoleEnum.ADMIN.toString()));
        }
        if (isDriver != null && isDriver) {
            return List.of(new SimpleGrantedAuthority(RoleEnum.DRIVER.toString()));
        }
        if (isCustomer != null && isCustomer) {
            return List.of(new SimpleGrantedAuthority(RoleEnum.CUSTOMER.toString()));
        }
        return roles;
    }
}
