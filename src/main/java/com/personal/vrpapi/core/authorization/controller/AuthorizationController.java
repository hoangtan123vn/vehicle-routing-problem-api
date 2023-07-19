package com.personal.vrpapi.core.authorization.controller;

import com.personal.vrpapi.core.authorization.dto.request.CreateUserRequest;
import com.personal.vrpapi.core.authorization.dto.request.LoginRequest;
import com.personal.vrpapi.core.authorization.dto.response.JwtResponse;
import com.personal.vrpapi.core.authorization.dto.response.UserData;
import com.personal.vrpapi.core.authorization.enums.RoleEnum;
import com.personal.vrpapi.core.authorization.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
public class AuthorizationController {

    @Resource
    private UserService userService;

    @PostMapping("/driver/token")
    public JwtResponse loginDriver(@RequestBody @Valid LoginRequest loginRequest) {
        return userService.authentication(loginRequest, RoleEnum.DRIVER);
    }

    @PostMapping("/customer/token")
    public JwtResponse loginCustomer(@RequestBody @Valid LoginRequest loginRequest) {
        return userService.authentication(loginRequest, RoleEnum.CUSTOMER);
    }

    @PostMapping("/driver/register")
    public UserData createDriver(@RequestBody @Valid CreateUserRequest userRequest) {
        return userService.createUser(userRequest, RoleEnum.DRIVER);
    }

    @PostMapping("/customer/register")
    public UserData createCustomer(@RequestBody @Valid CreateUserRequest userRequest) {
        return userService.createUser(userRequest, RoleEnum.CUSTOMER);
    }
}
