package com.personal.vrpapi.core.authorization.converter;

import com.personal.vrpapi.core.authorization.dto.request.UserRequest;
import com.personal.vrpapi.core.authorization.dto.response.UserData;
import com.personal.vrpapi.core.authorization.entity.Customer;
import com.personal.vrpapi.core.authorization.entity.Driver;
import com.personal.vrpapi.core.authorization.enums.RoleEnum;
import com.personal.vrpapi.core.authorization.repository.RoleRepository;
import com.personal.vrpapi.core.base.entity.AbstractUser;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserConverterImpl implements UserConverter {

    @Resource
    private RoleRepository roleRepository;

    @Override
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

    @Override
    public AbstractUser convertUserRequestToUser(UserRequest request) {
        AbstractUser user;
        if (RoleEnum.DRIVER.equals(request.getRole())) {
            user = new Driver();
        } else {
            user = new Customer();
        }
        user.setUserName(request.getUsername());
        user.setAddress(request.getAddress());
        user.setFirstName(request.getFirstName());
        user.setEmail(request.getEmail());
        user.setLastName(request.getLastName());
        user.setPhoneNumber(request.getPhoneNumber());
        return user;
    }
}