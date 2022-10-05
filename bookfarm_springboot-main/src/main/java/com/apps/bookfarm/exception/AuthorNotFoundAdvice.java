package com.apps.bookfarm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class AuthorNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(AuthorNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String authorNotFoundHandler(AuthorNotFoundException ex){
        return ex.getMessage();
    }
}
