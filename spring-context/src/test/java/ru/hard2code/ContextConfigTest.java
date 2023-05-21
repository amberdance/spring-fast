package ru.hard2code;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import ru.hard2code.config.ContextConfig;
import ru.hard2code.model.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = ContextConfig.class)
class ContextConfigTest {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    void testUserBeanLoads() {
        var user = applicationContext.getBean(User.class);

        assertEquals("username", user.getUsername());
        assertEquals("password", user.getPassword());
        assertEquals("ADMIN", user.getRole().getName());

    }

}
