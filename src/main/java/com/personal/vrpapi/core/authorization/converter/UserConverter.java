package com.personal.vrpapi.core.authorization.converter;

import com.personal.vrpapi.core.authorization.dto.request.CreateUserRequest;
import com.personal.vrpapi.core.authorization.dto.response.UserData;
import com.personal.vrpapi.core.authorization.entity.Role;
import com.personal.vrpapi.core.authorization.entity.User;
import com.personal.vrpapi.core.authorization.enums.RoleEnum;
import com.personal.vrpapi.core.authorization.repository.RoleRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserConverter {

    @Resource
    private RoleRepository roleRepository;

    public UserData convertUserToUserData(User user){
        UserData userData = new UserData();
        userData.setUsername(user.getUserName());
        userData.setAddress(user.getAddress());
        userData.setFirstName(user.getFirstName());
        userData.setEmail(user.getEmail());
        userData.setLastName(user.getLastName());
        userData.setPhone(user.getPhoneNumber());
        return userData;
    }

    public User convertUserRequestToUser(CreateUserRequest userRequest, RoleEnum roleEnum) {
        Role role = roleRepository.findByRoleName(roleEnum);
        return User.builder()
                .userName(userRequest.getUsername())
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .email(userRequest.getEmail())
                .phoneNumber(userRequest.getPhoneNumber())
                .role(role)
                .address(userRequest.getAddress())
                .build();
    }
}