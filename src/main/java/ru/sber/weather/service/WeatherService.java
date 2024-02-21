package ru.sber.weather.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.sber.weather.dto.WeatherResponse;
import ru.sber.weather.mapper.WeatherResponseMapper;

@Service
public class WeatherService {
    private static final String HTTPS_API_TOMORROW = "https://api.tomorrow.io/v4/weather/forecast";
    private static final String API_KEY = "IQYJJtcUToOzx3XYNeVlkvukJt9NZrOn";
    private static final String LOCATION = "42.3478,-71.0466";
    private WeatherResponseMapper mapper;

    public WeatherService(WeatherResponseMapper mapper) {
        this.mapper = mapper;
    }

    public WeatherResponse calculateWeatherResponse() {
        RestTemplate restTemplate = new RestTemplate();
        var body = restTemplate.getForEntity("https://api.tomorrow.io/v4/weather/forecast?location=42.3478,-71.0466&apikey=IQYJJtcUToOzx3XYNeVlkvukJt9NZrOn", String.class).getBody();
        return mapper.mapWeatherJson(body.toString());
    }

}
