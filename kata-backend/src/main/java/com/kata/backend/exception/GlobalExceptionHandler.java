package com.kata.backend.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * Handles IllegalArgumentException thrown by the application.
     *
     * @param exception  the IllegalArgumentException that was thrown
     * @param webRequest the current web request
     * @return a ResponseEntity with a message indicating the invalid number and a BAD_REQUEST status
     */
    @ExceptionHandler(CustomIllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(CustomIllegalArgumentException exception,
                                                                 WebRequest webRequest) {

        return new ResponseEntity<>("Le nombre saisi n'est pas valide. Veuillez entrer un nombre compris entre 0 et 100.", HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles MethodArgumentTypeMismatchException thrown when the path variable is not a valid number.
     *
     * @param exception  the exception thrown
     * @param webRequest the current web request
     * @return a ResponseEntity with a BAD_REQUEST status and a custom message
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException exception,
                                                                            WebRequest webRequest) {

        // Log the exception for further investigation
        logger.error("Invalid input: {}", exception.getMessage(), exception);

        // Return a custom error message
        return new ResponseEntity<>("Le format est invalide. Veuillez entrer un nombre valide.", HttpStatus.BAD_REQUEST);
    }

    /**
     * Generic handler for all other exceptions.
     *
     * @param exception  the exception thrown
     * @param webRequest the current web request
     * @return a ResponseEntity with a generic error message and INTERNAL_SERVER_ERROR status
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAllOtherExceptions(Exception exception, WebRequest webRequest) {
        // Log the exception for further investigation
        logger.error("An unexpected error occurred: {}", exception.getMessage(), exception);

        // Return a generic error message
        return new ResponseEntity<>("Une erreur inattendue s'est produite. Veuillez réessayer plus tard.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
