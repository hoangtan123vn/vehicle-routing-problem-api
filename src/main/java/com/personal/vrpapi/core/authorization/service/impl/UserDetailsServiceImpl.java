package com.personal.vrpapi.core.authorization.service.impl;

import com.personal.vrpapi.core.authorization.entity.User;
import com.personal.vrpapi.core.authorization.entity.UserPrincipal;
import com.personal.vrpapi.core.authorization.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("Username not found");
        }
        return UserPrincipal.createUser(user);
    }
}
