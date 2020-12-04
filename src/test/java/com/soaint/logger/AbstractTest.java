package com.soaint.logger;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author Alessandro Riega
 */
@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ApplicationTest.class)
@AutoConfigureMockMvc
@ActiveProfiles({"test"})
public class AbstractTest {

    @Autowired
    protected MockMvc mockMvc;
}
