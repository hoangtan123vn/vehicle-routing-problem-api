package com.personal.vrpapi.core.authorization.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class UserRequest {
    @JsonProperty
    @NotBlank(message = "username is required")
    private String username;

    @JsonProperty
    @NotBlank(message = "password is required")
    private String password;

    @JsonProperty
    @NotBlank(message = "address is required")
    private String address;

    @JsonProperty
    @NotBlank(message = "phoneNumber is required")
    private String phoneNumber;

    @JsonProperty
    @NotBlank(message = "firstName is required")
    private String firstName;

    @JsonProperty
    @NotBlank(message = "lastName is required")
    private String lastName;

    @JsonProperty
    @NotBlank(message = "email is required")
    private String email;
}