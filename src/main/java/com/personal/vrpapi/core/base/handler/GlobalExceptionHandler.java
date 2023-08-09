package com.personal.vrpapi.core.base.handler;

import com.personal.vrpapi.core.base.dto.ErrorMessage;
import com.personal.vrpapi.core.base.exception.BaseException;
import com.personal.vrpapi.googleapi.exception.ApiCommunicationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage handlerException(RuntimeException e){
        return ErrorMessage.builder()
                .error(e.getMessage())
                .status(HttpStatus.BAD_REQUEST.toString())
                .build();
    }

    @ExceptionHandler(ApiCommunicationException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage handlerApiCommunicationException(RuntimeException e){
        return ErrorMessage.builder()
                .error(e.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.toString())
                .build();
    }
}
