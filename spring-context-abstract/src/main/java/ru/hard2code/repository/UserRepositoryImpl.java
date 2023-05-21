package ru.hard2code.repository;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import ru.hard2code.model.User;

@Repository
@Qualifier("OriginalUserRepo")
@Lazy
@Slf4j
public class UserRepositoryImpl implements UserRepository {
    @Override
    public User saveUser(User user) {
        log.info("User saved: {}", user);
        return user;
    }


    @PostConstruct
    private void afterBeanCreated() {
        log.info("Bean {} created", UserRepositoryImpl.class);
    }
}
