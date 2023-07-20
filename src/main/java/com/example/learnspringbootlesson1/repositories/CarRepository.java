package com.example.learnspringbootlesson1.repositories;

import com.example.learnspringbootlesson1.model.Car;
import com.example.learnspringbootlesson1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findAllByUser(User user);
}
