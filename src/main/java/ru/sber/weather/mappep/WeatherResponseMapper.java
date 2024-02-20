package ru.sber.weather.mappep;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import ru.sber.weather.dto.Location;
import ru.sber.weather.dto.WeatherResponse;

@Component
public class WeatherResponseMapper {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    public WeatherResponse mapWeatherJson(String weatherJson) {
        JsonNode jsonNode = objectMapper.readTree(weatherJson);

        var minutely = getTimelines(jsonNode, "minutely", "temperatureApparent");
        var hourly = getTimelines(jsonNode, "hourly", "temperatureApparent");
        var daily = getTimelines(jsonNode, "daily", "temperatureApparentAvg");
        var location = getLocation(jsonNode);

        return new WeatherResponse(location, minutely, hourly, daily);
    }

    private double getTimelines(JsonNode jsonNode, String range, String nodeName) {
        return jsonNode
                .get("timelines")
                .get(range)
                .findValues(nodeName)
                .stream()
                .mapToDouble(JsonNode::doubleValue)
                .average()
                .getAsDouble();
    }

    private Location getLocation(JsonNode jsonNode) {
        String latitude = jsonNode.get("location").get("lat").toString();
        String longitude = jsonNode.get("location").get("lon").toString();

        return new Location(latitude, longitude);
    }

}
