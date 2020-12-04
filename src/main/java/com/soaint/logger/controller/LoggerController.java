package com.soaint.logger.controller;

import com.soaint.logger.controller.dto.LoggerRequest;
import com.soaint.logger.facade.LoggerFacade;
import com.soaint.logger.valid.ValuesAllowed;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Alessandro Riega
 */
@Validated
@RestController
@RequestMapping("/soaint")
public class LoggerController {

    private final LoggerFacade loggerFacade;

    public LoggerController(LoggerFacade loggerFacade) {
        this.loggerFacade = loggerFacade;
    }


    @PostMapping("/try/logger")
    public ResponseEntity<String> postLogger(@Valid @RequestBody LoggerRequest loggerRequest) {

        loggerFacade.callTypeLog(loggerRequest);

        return new ResponseEntity<>("execute type log from: " + loggerRequest.getTypeLog(), HttpStatus.OK);
    }

}
