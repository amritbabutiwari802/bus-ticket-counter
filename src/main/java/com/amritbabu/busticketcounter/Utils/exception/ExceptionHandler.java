package com.amritbabu.busticketcounter.Utils.exception;

import com.amritbabu.busticketcounter.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value= InvalidPrimaryKeyException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handler1(){
        return ErrorResponse.getInstance("no such item exists");
    }

}
