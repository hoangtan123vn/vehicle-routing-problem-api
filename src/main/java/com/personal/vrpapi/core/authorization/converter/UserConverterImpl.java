package com.personal.vrpapi.core.authorization.converter;

import com.personal.vrpapi.core.authorization.dto.request.UserRequest;
import com.personal.vrpapi.core.authorization.dto.response.UserData;
import com.personal.vrpapi.core.authorization.entity.Customer;
import com.personal.vrpapi.core.authorization.entity.Driver;
import com.personal.vrpapi.core.authorization.enums.RoleEnum;
import com.personal.vrpapi.core.authorization.repository.RoleRepository;
import com.personal.vrpapi.core.base.entity.AbstractUser;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class UserConverterImpl implements UserConverter {

    @Resource
    private RoleRepository roleRepository;

    @Override
    public UserData convertUserToUserData(AbstractUser user){
        UserData userData = new UserData();
        userData.setId(user.getId());
        userData.setUsername(user.getUserName());
        userData.setAddress(user.getAddress());
        userData.setFirstName(user.getFirstName());
        userData.setEmail(user.getEmail());
        userData.setLastName(user.getLastName());
        userData.setPhone(user.getPhoneNumber());
        return userData;
    }

    @Override
    public AbstractUser convertUserRequestToUser(UserRequest request, RoleEnum role) {
        AbstractUser user;
        if (RoleEnum.DRIVER.equals(role)) {
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

    @Override
    public Page<UserData> convertAll(List<AbstractUser> user) {
        return null;
    }
}