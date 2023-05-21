package ru.hard2code.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.hard2code.Main;
import ru.hard2code.model.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = Main.class)
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void whenUserSaved_thenProxyMustIncrementIdAndTransformToUpperName() {
        var userBefore = new User(1L, "somename");
        var userAfter = userService.saveUser(new User(userBefore.getId(),
                                                      userBefore.getName()));

        assertEquals(userBefore.getId(), userAfter.getId() - 1);
        assertEquals(userBefore.getName().toUpperCase(),
                     userAfter.getName().toUpperCase());

    }
}
