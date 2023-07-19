package com.personal.vrpapi.core.authorization.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class JwtResponse {
    private String token;
    private Date expiredTime;
}
