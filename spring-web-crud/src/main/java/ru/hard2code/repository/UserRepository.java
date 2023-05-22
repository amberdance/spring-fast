package ru.hard2code.repository;

import ru.hard2code.model.User;

import java.util.List;

public interface UserRepository {

    User saveUser(User user);

    List<User> findAllUsers();

}
