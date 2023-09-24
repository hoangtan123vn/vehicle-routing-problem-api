package com.personal.vrpapi.core.base.handler;

import com.personal.vrpapi.core.base.dto.ErrorMessage;
import com.personal.vrpapi.core.base.exception.BaseException;
import com.personal.vrpapi.core.base.exception.NotFoundException;
import com.personal.vrpapi.googleapi.exception.ApiCommunicationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage handlerException(BaseException e){
        return ErrorMessage.builder()
                .error(e.getMessage())
                .status(HttpStatus.BAD_REQUEST.toString())
                .build();
    }

    @ExceptionHandler(ApiCommunicationException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage handlerApiCommunicationException(ApiCommunicationException e){
        return ErrorMessage.builder()
                .error(e.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.toString())
                .build();
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage handlerRuntimeException(RuntimeException e){
        return ErrorMessage.builder()
                .error(e.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.toString())
                .build();
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage handlerNotFoundException(NotFoundException e){
        return ErrorMessage.builder()
                .error(e.getMessage())
                .status(HttpStatus.BAD_REQUEST.toString())
                .build();
    }
}
