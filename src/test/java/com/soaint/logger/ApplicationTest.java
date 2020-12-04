package com.soaint.logger;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alessandro Riega
 */
@Slf4j
@RestController
@EnableScheduling
@SpringBootApplication(scanBasePackages = {"com.soaint"})
public class ApplicationTest {

    @Test
    void contextLoads() {
    }
}
