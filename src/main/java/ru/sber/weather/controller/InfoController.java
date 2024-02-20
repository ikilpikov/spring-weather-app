package ru.sber.weather.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sber.weather.dto.WeatherResponse;
import ru.sber.weather.service.WeatherService;

@RestController
@RequestMapping("/weather")
public class InfoController {

    private WeatherService weatherService;

    public InfoController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/get")
    public void  getWeather() {
        System.out.println(weatherService.calculateWeatherResponse());
    }
}
