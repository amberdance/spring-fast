package ru.hard2code;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ru.hard2code.model.User;
import ru.hard2code.service.UserService;

@SpringBootApplication
@EnableAspectJAutoProxy
@Slf4j
public class Main {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(Main.class);
        var userService = ctx.getBean(UserService.class);
        log.info("Proxy save user: {}",
                 userService.saveUser(new User(null, "name")));
    }
}
