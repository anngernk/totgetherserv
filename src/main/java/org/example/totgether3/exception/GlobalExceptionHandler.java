package org.example.totgether3.exception;

import org.example.totgether3.dto.GeneralErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UsernameAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public GeneralErrorResponse handleUsernameAlreadyExistsException(UsernameAlreadyExistsException e) {
        return new GeneralErrorResponse(e.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public GeneralErrorResponse handleAuthenticationException(AuthenticationException ex) {
        return new GeneralErrorResponse(ex.getMessage(), LocalDateTime.now());
    }
}
