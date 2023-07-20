package com.example.learnspringbootlesson1.service;



import com.example.learnspringbootlesson1.dto.CarDto;
import com.example.learnspringbootlesson1.dto.UserDto;
import com.example.learnspringbootlesson1.model.Car;
import com.example.learnspringbootlesson1.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void saveUser(UserDto userDto);

    User getUserById(Long id);

    void updateUser(Long id, UserDto userDto);

    void deleteUser(Long id);

    List<Car> getInUserCars(Long id);

    void saveCarToUser(Long idUser, CarDto carDto);

}
