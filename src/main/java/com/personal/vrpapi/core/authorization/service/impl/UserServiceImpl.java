package com.personal.vrpapi.core.authorization.service.impl;

import com.personal.vrpapi.core.authorization.converter.UserConverter;
import com.personal.vrpapi.core.authorization.dto.request.LoginRequest;
import com.personal.vrpapi.core.authorization.dto.request.UserRequest;
import com.personal.vrpapi.core.authorization.dto.response.JwtResponse;
import com.personal.vrpapi.core.authorization.dto.response.UserData;
import com.personal.vrpapi.core.authorization.enums.RoleEnum;
import com.personal.vrpapi.core.authorization.repository.AbstractUserRepository;
import com.personal.vrpapi.core.authorization.service.JwtTokenService;
import com.personal.vrpapi.core.authorization.service.UserService;
import com.personal.vrpapi.core.base.entity.AbstractUser;
import com.personal.vrpapi.core.base.exception.BaseException;
import com.personal.vrpapi.core.base.exception.NotFoundException;
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
    private AbstractUserRepository userRepository;

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

    @Resource
    private AbstractUserRepository abstractUserRepository;

    @Override
    public JwtResponse authentication(LoginRequest loginRequest, RoleEnum roleEnum) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        } catch (DisabledException e) {
            throw new DisabledException("User have not permission to login", e);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Wrong Username or Password", e);
        } catch (Exception e) {
            throw new BaseException(e.getMessage());
        }
        AbstractUser user = userRepository.findByUserName(loginRequest.getUsername());

        if (!roleEnum.equals(user.getRole().getRoleName())){
            throw new BadCredentialsException("UnAuthorized!");
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(loginRequest.getUsername());

        final String token = jwtTokenService.generateToken(userDetails);
        Date expiredTime = new Date(System.currentTimeMillis() + jwtExpirationInMs);

        return new JwtResponse(token, expiredTime);
    }

    @Override
    public UserData createUser(UserRequest userRequest, RoleEnum roleEnum) {
        AbstractUser user = userRepository.findByUserName(userRequest.getUsername());
        if (Objects.isNull(user)){
            user = userConverter.convertUserRequestToUser(userRequest, roleEnum);
            user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
            userRepository.save(user);
            return userConverter.convertUserToUserData(user);
        } else {
            throw new BaseException("Username is existed");
        }
    }

    @Override
    public AbstractUser findById(Long userId) {
        return abstractUserRepository.
                findById(userId).orElseThrow(() -> new NotFoundException(String.format("User with %s not found", userId)));
    }

}
