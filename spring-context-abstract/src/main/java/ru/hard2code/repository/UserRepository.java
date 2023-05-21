package ru.hard2code.repository;

import ru.hard2code.model.User;

public interface UserRepository {
    User saveUser(User user);
}
