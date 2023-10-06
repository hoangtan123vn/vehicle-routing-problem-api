package com.personal.vrpapi.core.authorization.service;

import com.personal.vrpapi.core.authorization.dto.request.LoginRequest;
import com.personal.vrpapi.core.authorization.dto.request.UserRequest;
import com.personal.vrpapi.core.authorization.dto.response.JwtResponse;
import com.personal.vrpapi.core.authorization.dto.response.UserData;
import com.personal.vrpapi.core.authorization.enums.RoleEnum;
import com.personal.vrpapi.core.base.entity.AbstractUser;

public interface UserService {

    /**
     * handler Login base on Role
     * @param loginRequest
     * @param roleEnum
     * @return Jwtoken
     */
    JwtResponse authentication(LoginRequest loginRequest, RoleEnum roleEnum);

    /**
     * create User (DRIVER, CUSTOMER) base on Role
     * @param userRequest
     * @param roleEnum
     * @return User
     */
    UserData createUser(UserRequest userRequest, RoleEnum roleEnum);

    /**
     *
     * @param userId
     * @return
     */
    AbstractUser findById(Long userId);
}
