package ru.hard2code.service;

import ru.hard2code.model.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUsers();

}
