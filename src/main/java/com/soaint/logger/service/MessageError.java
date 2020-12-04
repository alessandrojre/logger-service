package com.soaint.logger.service;

import org.springframework.beans.factory.annotation.Value;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Alessandro Riega
 */
public class MessageError {

    protected static Logger logger = Logger.getLogger(Class.class.getName());

    @Value("${log.pathName}")
    protected String pathName;

    @Value("${code.error.type.save}")
    protected String codeErrorCustom;

    protected void messageError(Handler handler, String message) {
        logger.addHandler(handler);
        logger.log(Level.INFO, message);
    }
}
