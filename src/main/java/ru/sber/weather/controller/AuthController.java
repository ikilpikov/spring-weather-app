package ru.sber.weather.controller;

import org.springframework.web.bind.annotation.*;
import ru.sber.weather.entity.UserInfo;
import ru.sber.weather.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/new")
    public void createUser(@RequestBody UserInfo userInfo) {
        System.out.println(userInfo);
    }

}
