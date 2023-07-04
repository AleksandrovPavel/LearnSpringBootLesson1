package com.example.learnspringbootlesson1.dao;



import com.example.learnspringbootlesson1.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void saveUser(User user);

    User getUserById(Long id);

    void updateUser(Long id, User updateUser);

    void deleteUser(Long id);
}
