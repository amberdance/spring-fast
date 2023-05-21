package ru.hard2code;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.BeanFactoryAnnotationUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.hard2code.model.User;
import ru.hard2code.repository.UserRepository;


@SpringBootApplication
@Slf4j
public class Main {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(Main.class);

        var userRepository = BeanFactoryAnnotationUtils.qualifiedBeanOfType(ctx.getBeanFactory(),
                UserRepository.class, "OriginalUserRepo");

        userRepository.saveUser(new User("someName", "somePassword"));
        log.info("Repository bean: {}", userRepository);

    }
}
