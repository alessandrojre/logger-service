package com.soaint.logger.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Alessandro Riega
 */
@Slf4j
public class LoggerCustomException extends RuntimeException {
    public LoggerCustomException(String errorMessage) {
        super(errorMessage);
    }
}
