package com.example.learnspringbootlesson1.dao;

import com.example.learnspringbootlesson1.model.User;


import com.example.learnspringbootlesson1.repositories.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Component
public class UserDaoImpl implements UserDao {

    private final UserRepository userRepository;

    public UserDaoImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void updateUser(Long id, User updateUser) {
        User userUpdate = userRepository.findById(id).orElseThrow();
        userUpdate.setFirstName(updateUser.getFirstName());
        userUpdate.setLastName(updateUser.getLastName());
        userUpdate.setEmail(updateUser.getEmail());
        userRepository.save(userUpdate);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        User userDeleted = userRepository.findById(id).orElseThrow();
        userRepository.delete(userDeleted);
    }


}
