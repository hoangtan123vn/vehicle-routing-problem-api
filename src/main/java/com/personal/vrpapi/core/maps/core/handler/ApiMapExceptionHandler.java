package com.personal.vrpapi.core.maps.core.handler;

import com.personal.vrpapi.core.base.dto.ErrorMessage;
import com.personal.vrpapi.core.maps.core.exception.ValidVehicleIsEmptyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiMapExceptionHandler {

    @ExceptionHandler(ValidVehicleIsEmptyException.class)
    public ErrorMessage handlerValidVehicleIsEmptyException(ValidVehicleIsEmptyException e){
        return ErrorMessage.builder()
                .error(e.getMessage())
                .status(HttpStatus.BAD_REQUEST.toString())
                .build();
    }
}
