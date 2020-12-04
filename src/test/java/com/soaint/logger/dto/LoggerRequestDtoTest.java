package com.soaint.logger.dto;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Alessandro Riega
 */
@Slf4j
public class LoggerRequestDtoTest {

    @Test
    void initLoggerRequestDto() {
        LoggerRequestDto loggerRequestDto = new LoggerRequestDto();
        loggerRequestDto.setMessageError("messageError");
        loggerRequestDto.setTypeError("error");
        loggerRequestDto.setTypeLog("database");

        LoggerRequestDto loggerRequestDtoSecond = new LoggerRequestDto();
        loggerRequestDtoSecond.setMessageError("messageError");
        loggerRequestDtoSecond.setTypeError("error");
        loggerRequestDtoSecond.setTypeLog("database");

        log.info("loggerRequestDto.toString() {} ", loggerRequestDto.toString());
        log.info("loggerRequestDto.hashCode() {} ", loggerRequestDto.hashCode());
        log.info("loggerRequestDto.getMessageError() {} ", loggerRequestDto.getMessageError());
        log.info("loggerRequestDto.getTypeError() {} ", loggerRequestDto.getTypeError());

        assertEquals(loggerRequestDto.hashCode(), loggerRequestDtoSecond.hashCode());
        assertEquals(loggerRequestDto.equals(loggerRequestDtoSecond), loggerRequestDto.equals(loggerRequestDtoSecond));
    }
}
