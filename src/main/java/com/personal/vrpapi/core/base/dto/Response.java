package com.personal.vrpapi.core.base.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Response implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("data")
    private Object data;
}
