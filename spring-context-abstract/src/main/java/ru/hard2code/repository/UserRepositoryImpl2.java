package ru.hard2code.repository;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import ru.hard2code.model.User;

@Repository
@Slf4j
public class UserRepositoryImpl2 implements UserRepository {
    @Override
    public User saveUser(User user) {
        log.info("Save user invoked from: {}", UserRepositoryImpl2.class);
        log.info("User saved: {}", user);
        return user;
    }


    @PostConstruct
    private void afterBeanCreated() {
        log.info("Bean {} created", UserRepositoryImpl2.class);
    }
}
