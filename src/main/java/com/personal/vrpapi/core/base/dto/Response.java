package com.personal.vrpapi.core.base.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.personal.vrpapi.core.base.handler.Pageable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Response<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty("data")
    private T data;

    @JsonProperty("timestamp")
    private ZonedDateTime timestamp;

    @JsonProperty("page")
    private Pageable pageable;
}
