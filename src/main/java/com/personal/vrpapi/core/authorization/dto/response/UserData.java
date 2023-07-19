package com.personal.vrpapi.core.authorization.dto.response;

import lombok.Data;

@Data
public class UserData {
    String username;
    String address;
    String email;
    String lastName;
    String firstName;
    String phone;
}
