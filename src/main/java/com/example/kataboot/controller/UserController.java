package com.example.kataboot.controller;


import com.example.kataboot.model.User;
import com.example.kataboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }

    @GetMapping(value = "/delete")
    public String delete(Long id) {
        userService.deleteUserByID(id);
        return "redirect:/";
    }

    @GetMapping(value = "/update")
    public String update(ModelMap modelMap, Long id) {
        modelMap.addAttribute("user", userService.getUserByID(id));
        return "update";
    }

    @PostMapping(value = "/save")
    public String save(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "/add")
    public String create(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        return "add";
    }

}
