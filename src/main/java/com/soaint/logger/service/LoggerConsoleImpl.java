package com.soaint.logger.service;

import com.soaint.logger.dto.LoggerRequestDto;
import org.springframework.stereotype.Service;

import java.util.logging.ConsoleHandler;

/**
 * @author Alessandro Riega
 */
@Service("loggerConsole")
public class LoggerConsoleImpl extends MessageError implements LoggerService {

    @Override
    public void logMessage(LoggerRequestDto loggerRequestDto) {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        messageError(consoleHandler, loggerRequestDto.getMessageError());
    }

}
