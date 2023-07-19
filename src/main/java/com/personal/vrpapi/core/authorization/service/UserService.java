package com.personal.vrpapi.core.authorization.service;

import com.personal.vrpapi.core.authorization.dto.request.CreateUserRequest;
import com.personal.vrpapi.core.authorization.dto.request.LoginRequest;
import com.personal.vrpapi.core.authorization.dto.response.JwtResponse;
import com.personal.vrpapi.core.authorization.dto.response.UserData;
import com.personal.vrpapi.core.authorization.enums.RoleEnum;

public interface UserService {

    JwtResponse authentication(LoginRequest loginRequest, RoleEnum roleEnum);

    UserData createUser(CreateUserRequest userReques, RoleEnum roleEnum);
}
