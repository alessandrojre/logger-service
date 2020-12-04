package com.soaint.logger.service;

import com.soaint.logger.dto.LoggerRequestDto;
import com.soaint.logger.exception.LoggerCustomException;
import com.soaint.logger.repository.LoggerRepository;
import org.springframework.stereotype.Service;

/**
 * @author Alessandro Riega
 */
@Service("loggerDatabase")
public class LoggerDatabaseImpl extends MessageError implements LoggerService {

    private final LoggerRepository loggerRepository;

    public LoggerDatabaseImpl(LoggerRepository loggerRepository) {
        this.loggerRepository = loggerRepository;
    }

    @Override
    public void logMessage(LoggerRequestDto loggerRequestDto) {
        if (codeErrorCustom.contentEquals(loggerRequestDto.getTypeError())) {
            loggerRepository.saveLog(loggerRequestDto.getMessageError(), loggerRequestDto.getTypeError());
        } else {
            throw new LoggerCustomException("only supported type codeError : " + codeErrorCustom);
        }
    }
}
