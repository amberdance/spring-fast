package ru.hard2code.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import ru.hard2code.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
@Slf4j
public class UserRepositoryImpl implements UserRepository {

    private final List<User> users = new ArrayList<>();

    @Override
    public User saveUser(User user) {
        var id = new Random().nextLong(99);
        user.setId(id);
        users.add(user);
        log.info("User added to list: {}", user);
        return user;
    }

    @Override
    public List<User> findAllUsers() {
        log.info("Getting all users: {}", users);
        return users;
    }

}
