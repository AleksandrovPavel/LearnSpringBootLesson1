package com.example.learnspringbootlesson1.service;

import com.example.learnspringbootlesson1.dto.CarDto;
import com.example.learnspringbootlesson1.model.Car;

import java.util.List;

public interface CarService {

    List<Car> getAllCars();

    Car getCarById(Long id);

    void updateCar(Long id, CarDto carDto);

    void deleteCar(Long id);

    Long idUser(Long idCar);
}
