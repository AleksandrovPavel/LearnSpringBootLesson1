package com.example.learnspringbootlesson1.service;



import com.example.learnspringbootlesson1.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void saveUser(User user);

    User getUserById(Long id);

    void updateUser(Long id, User updateUser);

    void deleteUser(Long id);
}
