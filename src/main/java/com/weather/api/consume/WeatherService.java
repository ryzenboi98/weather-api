package com.weather.api.consume;

import com.weather.api.entities.LocationDTO;
import com.weather.api.exceptions.LocationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${resource.weather}")
    private String weatherURL;

    @Value("${resource.api_key}")
    private String weatherAPIKey;

    public LocationDTO getLocation(String location) {
        String url = weatherURL + "/weather" + "?appid=" + weatherAPIKey + "&q="+ location + "&units=metric";

        System.out.println(url);

        LocationDTO weather;

        try {
            weather = restTemplate.getForObject(url, LocationDTO.class);
        } catch (HttpClientErrorException e) {
            throw new LocationNotFoundException();
        }

        return weather;
    }
}
