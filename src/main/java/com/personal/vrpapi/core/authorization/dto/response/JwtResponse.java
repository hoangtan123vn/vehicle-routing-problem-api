package com.personal.vrpapi.core.authorization.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class JwtResponse implements Serializable {

    private static final long serialVersionUID = 2405172041950251807L;

    private String token;
    private Date expiredTime;
}
