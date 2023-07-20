package com.example.learnspringbootlesson1.service;


import com.example.learnspringbootlesson1.dto.CarDto;
import com.example.learnspringbootlesson1.dto.UserDto;
import com.example.learnspringbootlesson1.model.Car;
import com.example.learnspringbootlesson1.model.User;
import com.example.learnspringbootlesson1.repositories.CarRepository;
import com.example.learnspringbootlesson1.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CarRepository carRepository;


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
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setLastName(userDto.getLastName());
        user.setFirstName(userDto.getFirstName());
        user.setEmail(userDto.getEmail());
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void updateUser(Long id, UserDto userDto) {
        User userUpdate = userRepository.findById(id).orElseThrow();
        userUpdate.setFirstName(userDto.getFirstName());
        userUpdate.setLastName(userDto.getLastName());
        userUpdate.setEmail(userDto.getEmail());
        userRepository.save(userUpdate);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        User userDeleted = userRepository.findById(id).orElseThrow();
        userRepository.delete(userDeleted);
    }

    @Override
    public List<Car> getInUserCars(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return carRepository.findAllByUser(user);
    }


    @Override
    public void saveCarToUser(Long idUser, CarDto carDto) {
        User user = userRepository.findById(idUser).orElseThrow();
        Car car = new Car();
        car.setModel(carDto.getModel());
        car.setSeries(carDto.getSeries());
        car.setUser(user);
        carRepository.save(car);
    }
}
