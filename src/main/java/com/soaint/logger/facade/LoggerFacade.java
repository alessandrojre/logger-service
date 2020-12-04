package com.soaint.logger.facade;

import com.soaint.logger.controller.dto.LoggerRequest;
import com.soaint.logger.dto.LoggerRequestDto;
import com.soaint.logger.service.LoggerService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author Alessandro Riega
 */
@Component
public class LoggerFacade {

    @Qualifier("loggerConsole")
    private final LoggerService loggerConsole;

    @Qualifier("loggerDatabase")
    private final LoggerService loggerDatabase;

    @Qualifier("loggerFile")
    private final LoggerService loggerFile;

    public LoggerFacade(LoggerService loggerConsole,
                        LoggerService loggerDatabase,
                        LoggerService loggerFile) {
        this.loggerConsole = loggerConsole;
        this.loggerDatabase = loggerDatabase;
        this.loggerFile = loggerFile;
    }


    public void callTypeLog(LoggerRequest loggerRequest) {
        LoggerRequestDto loggerRequestDto = buildRequest(loggerRequest);
        switch (loggerRequestDto.getTypeLog()) {
            case "CONSOLE":
                loggerConsole.logMessage(loggerRequestDto);
                break;
            case "DATABASE":
                loggerDatabase.logMessage(loggerRequestDto);
                break;
            case "FILE":
                loggerFile.logMessage(loggerRequestDto);
                break;
            default:
                break;
        }
    }

    private LoggerRequestDto buildRequest(LoggerRequest loggerRequest) {
        return LoggerRequestDto.builder()
                .messageError(loggerRequest.getMessageError())
                .typeError(loggerRequest.getTypeError())
                .typeLog(loggerRequest.getTypeLog().toUpperCase()).build();
    }
}
