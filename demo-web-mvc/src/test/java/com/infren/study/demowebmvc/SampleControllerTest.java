package com.infren.study.demowebmvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.options;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(MockitoExtension.class)
@WebMvcTest
class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void eventTest1() throws Exception{
        mockMvc.perform(get("/events/1"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("events 1"));
        mockMvc.perform(get("/events/2"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("events 2"));
        mockMvc.perform(get("/events/3"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("events 3"));
    }

    @Test
    public void eventTestPost() throws Exception{
        mockMvc.perform(post("/events/")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Test
    public void eventTestDelete() throws Exception{
        mockMvc.perform(delete("/events/1"))
            .andDo(print())
            .andExpect(content().string("events 1"))
            .andExpect(status().isOk());
    }

    @Test
    public void eventTestPut() throws Exception{
        mockMvc.perform(put("/events/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(content().string("events 1"))
            .andExpect(status().isOk());
    }



}