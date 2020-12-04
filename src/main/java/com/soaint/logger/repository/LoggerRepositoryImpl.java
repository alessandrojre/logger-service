package com.soaint.logger.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author Alessandro Riega
 */
@Repository
public class LoggerRepositoryImpl implements LoggerRepository {

    private final JdbcTemplate jdbcTemplate;

    public LoggerRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveLog(String message, String errorCode) {
        jdbcTemplate.update(
                "insert into soaint.Logger(message, errorCode) values(?,?)",
                message, errorCode);
    }
}
