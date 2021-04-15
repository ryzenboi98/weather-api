package com.weather.api.consume;

import com.weather.api.entities.WeatherDTO;
import com.weather.api.exceptions.LocationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WeatherService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${resource.weather}")
    private String weatherURL;

    @Value("${resource.api_key}")
    private String weatherAPIKey;

    public WeatherDTO getOne(String location) {
        String url = weatherURL + "/weather" + "?appid=" + weatherAPIKey + "&q="+ location + "&units=metric";

        WeatherDTO weather;

        try {
            weather = restTemplate.getForObject(url, WeatherDTO.class);
        } catch (HttpClientErrorException e) {
            throw new LocationNotFoundException();
        }

        return weather;
    }
}
