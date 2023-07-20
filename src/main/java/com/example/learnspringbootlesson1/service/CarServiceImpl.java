package com.example.learnspringbootlesson1.service;

import com.example.learnspringbootlesson1.dto.CarDto;
import com.example.learnspringbootlesson1.model.Car;
import com.example.learnspringbootlesson1.model.User;
import com.example.learnspringbootlesson1.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Car getCarById(Long id) {
        return carRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public void updateCar(Long id, CarDto carDto) {
        Car carUpdate = carRepository.findById(id).orElseThrow();
        carUpdate.setModel(carDto.getModel());
        carUpdate.setSeries(carDto.getSeries());
        carRepository.save(carUpdate);
    }

    @Override
    @Transactional
    public void deleteCar(Long id) {
        Car carDeleted = carRepository.findById(id).orElseThrow();
        carRepository.delete(carDeleted);
    }

    @Override
    public Long idUser(Long idCar) {
        long number;
        Car car = carRepository.findById(idCar).orElseThrow();
        User user = car.getUser();
        number = user.getId();
        return number;
    }
}
