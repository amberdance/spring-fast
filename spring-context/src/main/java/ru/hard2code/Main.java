package ru.hard2code;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.hard2code.config.ContextConfig;

@Slf4j
public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ContextConfig.class);
        log.info("User from context: {}", context.getBean("user"));
    }
}
