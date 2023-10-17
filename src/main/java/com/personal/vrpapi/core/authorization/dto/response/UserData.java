package com.personal.vrpapi.core.authorization.dto.response;

import lombok.Data;

@Data
public class UserData {
    private Long id;
    private String username;
    private String address;
    private String email;
    private String lastName;
    private String firstName;
    private String phone;
}
