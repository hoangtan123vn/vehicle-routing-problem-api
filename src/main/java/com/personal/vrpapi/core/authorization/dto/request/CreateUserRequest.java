package com.personal.vrpapi.core.authorization.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateUserRequest {
    @NotBlank(message = "username is required")
    private String username;

    @NotBlank(message = "password is required")
    private String password;

    @NotBlank(message = "address is required")
    private String address;

    @NotBlank(message = "phoneNumber is required")
    private String phoneNumber;

    @NotBlank(message = "firstName is required")
    private String firstName;

    @NotBlank(message = "lastName is required")
    private String lastName;

    @NotBlank(message = "email is required")
    private String email;

}