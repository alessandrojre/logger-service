package com.soaint.logger.controller;

import com.soaint.logger.AbstractTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Alessandro Riega
 */
public class LoggerControllerTest extends AbstractTest {


    @Test
    void loggerDatabaseSuccess() throws Exception {

        ResultActions actions = this.mockMvc.perform(MockMvcRequestBuilders.post("/soaint/try/logger")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"typeLog\": \"database\", \"typeError\": \"warning\", \"messageError\": \"Internal Server Error 2\"}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200));

        //validate Response
        actions.andExpect(MockMvcResultMatchers.content().string("execute type log from: database"));
    }


    @Test
    void loggerFileSuccess() throws Exception {

        ResultActions actions = this.mockMvc.perform(MockMvcRequestBuilders.post("/soaint/try/logger")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"typeLog\": \"file\", \"typeError\": \"warning\", \"messageError\": \"Warning error message\"}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200));

        //validate Response
        actions.andExpect(MockMvcResultMatchers.content().string("execute type log from: file"));
    }


    @Test
    void loggerConsoleSuccess() throws Exception {

        ResultActions actions = this.mockMvc.perform(MockMvcRequestBuilders.post("/soaint/try/logger")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"typeLog\": \"console\", \"typeError\": \"warning\", \"messageError\": \"Warning error message\"}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200));

        //validate Response
        actions.andExpect(MockMvcResultMatchers.content().string("execute type log from: console"));
    }


    @Test
    void loggerBadRequest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/soaint/try/logger")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"typeLog\": \"database\", \"error\": \"warning\", \"messageError\": \"Internal Server Error 2\"}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(400));
    }


}
