package com.example.learnspringbootlesson1.controller;

import com.example.learnspringbootlesson1.dto.CarDto;
import com.example.learnspringbootlesson1.dto.UserDto;
import com.example.learnspringbootlesson1.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "user/all_users";
    }

    @GetMapping("/{user-id}")
    public String getUserById(@PathVariable("user-id") Long userId,
                              @ModelAttribute("new_car") CarDto carDto,
                              Model model) {
        model.addAttribute("user", userService.getUserById(userId));
        model.addAttribute("car", userService.getInUserCars(userId));
        return "user/user_by_id";
    }

    @PostMapping("/{user-id}/new_car_to_user")
    public String newCarToUser(@PathVariable("user-id") Long userId,
                               @ModelAttribute("new_car") @Valid CarDto carDto,
                               BindingResult bindingResult, Model model) {
        model.addAttribute("user", userService.getUserById(userId));
        model.addAttribute("car", userService.getInUserCars(userId));
        if (bindingResult.hasErrors()) {
            return "user/user_by_id";
        }
        userService.saveCarToUser(userId, carDto);
        return "redirect:/user/" + userId;
    }

    @GetMapping("/new_user")
    public String newUser(@ModelAttribute("user") UserDto userDto) {
        return "user/new_user";
    }

    @PostMapping("/save_User")
    public String saveUser(@ModelAttribute("user") @Valid UserDto userDto,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/new_user";
        }
        userService.saveUser(userDto);
        return "redirect:/user";
    }

    @GetMapping("/{user-id}/update")
    public String edit(@PathVariable("user-id") long userId, Model model) {
        model.addAttribute("user", userService.getUserById(userId));
        return "user/update_user";
    }

    @PatchMapping("/{user-id}/user_update")
    public String update(@ModelAttribute("update_user") @Valid UserDto userDto,
                         BindingResult bindingResult,
                         @PathVariable("user-id") Long userId) {
        if (bindingResult.hasErrors()) {
            return "user/update_user";
        }
        userService.updateUser(userId, userDto);
        return "redirect:/user/" + userId;
    }

    @GetMapping("/{user-id}/delete_user")
    public String delete(@PathVariable("user-id") Long carId) {
        userService.deleteUser(carId);
        return "redirect:/user";
    }


}
