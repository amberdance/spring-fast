package ru.hard2code.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import ru.hard2code.Main;
import ru.hard2code.model.User;
import ru.hard2code.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = Main.class)
class ApplicationContextConfigTest {

    @Autowired
    @Qualifier("OriginalUserRepo")
    private UserRepository userRepository;

    private static final String USERNAME = "TEST_USERNAME";
    private static final String PASSWORD = "TEST_PASSWORD";
    private static final User TEST_USER = new User(USERNAME, PASSWORD);

    @Test
    void testCreateUser() {
        var savedUser = userRepository.saveUser(TEST_USER);
        assertEquals(USERNAME, savedUser.getUsername());
        assertEquals(PASSWORD, savedUser.getPassword());
    }
}
