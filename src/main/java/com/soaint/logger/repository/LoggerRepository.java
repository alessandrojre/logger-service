package com.soaint.logger.repository;

/**
 * @author Alessandro Riega
 */
public interface LoggerRepository {
    void saveLog(String message, String errorCode);
}
