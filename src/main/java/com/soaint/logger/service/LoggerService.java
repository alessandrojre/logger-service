package com.soaint.logger.service;

import com.soaint.logger.dto.LoggerRequestDto;

/**
 * @author Alessandro Riega
 */
public interface LoggerService {

    void logMessage(LoggerRequestDto loggerRequestDto);
}
