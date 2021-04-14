package com.weather.api.consume;

import com.weather.api.entities.WeatherDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
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

    public WeatherDTO getOne() {
        String url = weatherURL + "/weather" + "?appid=" + weatherAPIKey + "&q=Viseu" + "&units=metric";

        return restTemplate.getForObject(url, WeatherDTO.class);
    }
}
