package com.personal.vrpapi.core.authorization.converter;

import com.personal.vrpapi.core.authorization.dto.response.UserData;
import com.personal.vrpapi.core.authorization.repository.RoleRepository;
import com.personal.vrpapi.core.base.entity.AbstractUser;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserConverter {

    @Resource
    private RoleRepository roleRepository;

    public UserData convertUserToUserData(AbstractUser user){
        UserData userData = new UserData();
        userData.setUsername(user.getUserName());
        userData.setAddress(user.getAddress());
        userData.setFirstName(user.getFirstName());
        userData.setEmail(user.getEmail());
        userData.setLastName(user.getLastName());
        userData.setPhone(user.getPhoneNumber());
        return userData;
    }
}