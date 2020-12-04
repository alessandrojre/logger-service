package com.soaint.logger.controller.dto;

import com.soaint.logger.valid.ValuesAllowed;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @author Alessandro Riega
 */
@Getter
@Setter
public class LoggerRequest {

    @NotNull(message = "typeLog is required")
    @ValuesAllowed(propName = "typeLog", values = {"database", "console", "file"})
    private String typeLog;


    @NotNull(message = "typeError is required")
    @ValuesAllowed(propName = "typeError", values = {"error", "warning", "info"})
    private String typeError;

    @NotNull(message = "messageError is required")
    private String messageError;
}
