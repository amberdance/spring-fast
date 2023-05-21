package ru.hard2code.model;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Getter
@Slf4j
public class Role {

    private final String name = "ADMIN";

    public Role() {
        log.info("Role constructor invoked");
    }
}
