package com.kata.backend.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * Handles IllegalArgumentException thrown by the application.
     *
     * @param exception the IllegalArgumentException that was thrown
     * @param webRequest the current web request
     * @return a ResponseEntity with a message indicating the invalid number and a BAD_REQUEST status
     */
    @ExceptionHandler(CustomIllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(CustomIllegalArgumentException exception,
                                                                 WebRequest webRequest) {

        logger.error("Le nombre saisi n'est pas valide. Veuillez entrer un nombre compris entre 0 et 100.", exception.getStackTrace());
        return new ResponseEntity<>("Le nombre saisi n'est pas valide. Veuillez entrer un nombre compris entre 0 et 100.", HttpStatus.BAD_REQUEST);
    }

}