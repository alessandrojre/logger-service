package com.soaint.logger.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ariegaes
 */
@Builder
@Data
@NoArgsConstructor
public class LoggerRequestDto {

    private String typeLog;

    private String typeError;

    private String messageError;

    public LoggerRequestDto(String typeLog, String typeError, String messageError) {
        this.typeLog = typeLog;
        this.typeError = typeError;
        this.messageError = messageError;
    }
}
