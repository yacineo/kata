package com.kata.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * CustomIllegalArgumentException is a custom exception class that extends RuntimeException.
 * It is used to indicate that an illegal argument has been passed to a method.
 * This exception is annotated with @ResponseStatus to return a BAD_REQUEST (400) status code
 * when it's thrown in a Spring application.
 *
 * <p>Methods:
 * <ul>
 *   <li>{@link #CustomIllegalArgumentException(String)} - Constructs a new exception with the specified detail message.</li>
 *   <li>{@link #log(String)} - Logs the error message using SLF4J Logger.</li>
 * </ul>
 */

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CustomIllegalArgumentException extends RuntimeException {

    private static final Logger logger = LoggerFactory.getLogger(CustomIllegalArgumentException.class);

    public CustomIllegalArgumentException(String message) {
        super(message);
        log(message);
    }

    private void log(String message) {
        logger.error("CustomIllegalArgumentException:  {}", message);
    }
}
