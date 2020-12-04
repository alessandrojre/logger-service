package com.soaint.logger.service;

import com.soaint.logger.dto.LoggerRequestDto;
import com.soaint.logger.exception.LoggerCustomException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

/**
 * @author Alessandro Riega
 */
@Service("loggerFile")
public class LoggerFileImpl extends MessageError implements LoggerService {

    @Override
    public void logMessage(LoggerRequestDto loggerRequestDto) {
        try {
            File file = new File(pathName);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileHandler fileHandler = new FileHandler(pathName);
            messageError(fileHandler, loggerRequestDto.getMessageError());
        } catch (IOException e) {
            throw new LoggerCustomException("error registered in file");
        }
    }


}
