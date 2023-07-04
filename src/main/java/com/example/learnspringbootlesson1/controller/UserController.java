package com.example.learnspringbootlesson1.controller;

import com.example.learnspringbootlesson1.model.User;
import com.example.learnspringbootlesson1.service.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "user/all_users";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user/user_by_id";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "user/new";
    }

    @PostMapping()
    public String saveUser(@ModelAttribute("user") @Valid User user,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/new";
        }
        userService.saveUser(user);
        return "redirect:/user";
    }

    @GetMapping("/{id}/update")
    public String edit(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user/update";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
                         @PathVariable("id") long id) {
        if (bindingResult.hasErrors()) {
            return "user/update";
        }
        userService.updateUser(id, user);
        return "redirect:/user";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/user";
    }
}
