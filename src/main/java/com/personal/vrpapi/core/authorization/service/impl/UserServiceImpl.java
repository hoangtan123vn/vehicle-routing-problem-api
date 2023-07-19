package com.personal.vrpapi.core.authorization.service.impl;

import com.personal.vrpapi.core.authorization.converter.UserConverter;
import com.personal.vrpapi.core.authorization.dto.request.CreateUserRequest;
import com.personal.vrpapi.core.authorization.dto.request.LoginRequest;
import com.personal.vrpapi.core.authorization.dto.response.JwtResponse;
import com.personal.vrpapi.core.authorization.dto.response.UserData;
import com.personal.vrpapi.core.authorization.entity.User;
import com.personal.vrpapi.core.authorization.enums.RoleEnum;
import com.personal.vrpapi.core.authorization.repository.UserRepository;
import com.personal.vrpapi.core.authorization.service.JwtTokenService;
import com.personal.vrpapi.core.authorization.service.UserService;
import com.personal.vrpapi.core.base.exception.BaseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private UserRepository userRepository;

    @Resource
    private UserDetailsService userDetailsService;

    @Resource
    private JwtTokenService jwtTokenService;

    @Value("${app.jwtExpirationInMs}")
    private int jwtExpirationInMs;

    @Resource
    private UserConverter userConverter;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public JwtResponse authentication(LoginRequest loginRequest, RoleEnum roleEnum) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        } catch (DisabledException e) {
            throw new DisabledException("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Wrong Username or Password", e);
        } catch (Exception e) {
            throw new BaseException("Exception : " +  e.getMessage());
        }
        User user = userRepository.findByUserName(loginRequest.getUsername());

        if (!roleEnum.equals(user.getRole().getRoleName())){
            throw new BadCredentialsException("User can not access");
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(loginRequest.getUsername());

        final String token = jwtTokenService.generateToken(userDetails);
        Date expiredTime = new Date(System.currentTimeMillis() + jwtExpirationInMs);

        return new JwtResponse(token, expiredTime);
    }

    @Override
    public UserData createUser(CreateUserRequest userRequest, RoleEnum roleEnum) {
        User user = userRepository.findByUserName(userRequest.getUsername());
        if (Objects.isNull(user)){
            user = userConverter.convertUserRequestToUser(userRequest, roleEnum);
            user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
            userRepository.save(user);
            return userConverter.convertUserToUserData(user);
        } else {
            throw new BaseException("Username is existed");
        }
    }
}
