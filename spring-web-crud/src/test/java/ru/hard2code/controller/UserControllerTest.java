package ru.hard2code.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.hard2code.service.UserService;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private UserService userService;

    private static final String PATH = "/users";
    private static final String TEST_NAME = "Test UserName";


    @Test
    void testGetAllUsers() throws Exception {
        mvc.perform(get(PATH)
                        .accept(MediaType.TEXT_HTML)
                        .contentType(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name("users"))
                .andExpect(model().attributeExists("users"));
    }

    @Test
    void testCreateUser() throws Exception {
        mvc.perform(post(PATH)
                        .param("name", TEST_NAME)
                        .accept(MediaType.TEXT_HTML)
                        .contentType(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name("users"))
                .andExpect(model().attributeExists("users"));

        assertFalse(userService.getAllUsers().isEmpty());
    }

}
