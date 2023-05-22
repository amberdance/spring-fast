package ru.hard2code.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hard2code.model.User;
import ru.hard2code.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.saveUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAllUsers();
    }

}
