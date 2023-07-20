package com.example.learnspringbootlesson1.controller;

import com.example.learnspringbootlesson1.dto.CarDto;
import com.example.learnspringbootlesson1.service.CarServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/car")
public class CarController {

    private final CarServiceImpl carService;

    @Autowired
    public CarController(CarServiceImpl carService) {
        this.carService = carService;
    }

    @GetMapping()
    public String getAllCars(Model model) {
        model.addAttribute("cars", carService.getAllCars());
        return "car/all_cars";
    }

    @GetMapping("/{car-id}")
    public String getCarById(@PathVariable("car-id") long carId, Model model) {
        model.addAttribute("car", carService.getCarById(carId));
        return "car/car_by_id";
    }

    @GetMapping("/{car-id}/transition")
    public String transition(@PathVariable("car-id") Long carId) {
        long number = carService.idUser(carId);
        return "redirect:/user/" + number;
    }


    @GetMapping("/{car-id}/update")
    public String edit(@PathVariable("car-id") Long carId, Model model) {
        model.addAttribute("car", carService.getCarById(carId));
        return "car/update_car";
    }

    @PatchMapping("/{car-id}/car_update")
    public String update(@ModelAttribute("update_car") @Valid CarDto carDto,
                         BindingResult bindingResult,
                         @PathVariable("car-id") Long carId) {

        if (bindingResult.hasErrors()) {
            return "car/update_car";
        }

        carService.updateCar(carId, carDto);
        return "redirect:/user/" + carId;
    }
    @GetMapping("/{car-id}/delete_car")
    public String delete(@PathVariable("car-id") long carId) {
        long number = carService.idUser(carId);
        carService.deleteCar(carId);
        return "redirect:/user/" + number;
    }

}
