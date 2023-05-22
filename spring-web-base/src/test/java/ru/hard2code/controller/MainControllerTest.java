package ru.hard2code.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
class MainControllerTest {

    @Autowired
    private MockMvc mvc;

    private final static String COLOR_PARAM = "Red";
    private final static String USERNAME_PARAM = "Username";
    private final static String VIEW_NAME = "home";

    @Test
    void testHomePageWithRequestParams() throws Exception {
        mvc.perform(get("/", COLOR_PARAM, USERNAME_PARAM)
                   .param("color", COLOR_PARAM)
                   .param("username", USERNAME_PARAM)
                   .accept(MediaType.TEXT_HTML)
                   .contentType(MediaType.TEXT_HTML))
           .andExpect(status().isOk())
           .andExpect(view().name(VIEW_NAME))
           .andExpect(model().attributeExists("color"))
           .andExpect(model().attributeExists("username"));
    }

    @Test
    void testHomePageWithPathParams() throws Exception {
        mvc.perform(get("/{color}/{username}", COLOR_PARAM, USERNAME_PARAM)
                   .accept(MediaType.TEXT_HTML)
                   .contentType(MediaType.TEXT_HTML))
           .andExpect(status().isOk())
           .andExpect(view().name(VIEW_NAME))
           .andExpect(model().attributeExists("color"))
           .andExpect(model().attributeExists("username"));
    }
}
