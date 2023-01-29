package edu.miu.waa.postservice.advice;

import org.modelmapper.spi.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionAdvice {

    @ExceptionHandler(value = BadCredentialsException.class) // when Invalid Credentials
    public ResponseEntity<ErrorMessage> handleInvalidCredentialsException(
            BadCredentialsException e) {
        return new ResponseEntity<>(
                new ErrorMessage(e.getMessage()), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = Exception.class) // when any other exception occurs
    public ResponseEntity<ErrorMessage> handleGlobalException(
            Exception e) {
        return new ResponseEntity<>(
                new ErrorMessage(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
