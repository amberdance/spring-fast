package ru.hard2code.model;


import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Getter
@Slf4j
public class User {

    private final String username = "username";
    private final String password = "password";
    private final Role role;


    public User(Role role) {
        log.info("User constructor invoked");
        this.role = role;
    }

    @PostConstruct
    private void afterBeanCreated() {
        log.info("Bean {} created", User.class);
    }
}
