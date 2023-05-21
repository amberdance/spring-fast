package ru.hard2code.service;

import org.springframework.stereotype.Service;
import ru.hard2code.annotation.IncrementId;
import ru.hard2code.annotation.Uppercase;
import ru.hard2code.model.User;

@Service
public class UserServiceImpl implements UserService {

    @Override
    @IncrementId
    @Uppercase
    public User saveUser(User user) {
        return user;
    }
}
