package ru.sber.weather.service;

import org.springframework.stereotype.Service;
import ru.sber.weather.dto.AuthRequest;
import ru.sber.weather.entity.UserInfo;

@Service
public class UserService {

    public String register(UserInfo userInfo) {
        return "JWT";
    }

    public String login(AuthRequest request) {
        return "JWT";
    }

}
