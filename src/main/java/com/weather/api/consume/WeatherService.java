package com.weather.api.consume;

import com.weather.api.entities.location.LocationDTO;
import com.weather.api.entities.weather.WeatherDTO;
import com.weather.api.exceptions.LocationNotFoundException;
import com.weather.api.exceptions.LocationNotProvidedException;
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

        LocationDTO local;

        try {
            local = restTemplate.getForObject(url, LocationDTO.class);
        } catch (HttpClientErrorException e) {
            throw new LocationNotFoundException();
        }

        String[] parts = location.split(",");

        if(parts[0].equals("")) {
            throw  new LocationNotProvidedException();
        }

        assert local != null;
        local.setLocation(parts[0]);

        return local;
    }

    public WeatherDTO getWeather(float lat, float lon) {
        String url = weatherURL + "/onecall" + "?appid=" + weatherAPIKey
                + "&lat="+ lat +"&lon="+ lon + "&exclude=minutely" + "&units=metric";

        WeatherDTO weather;

        try {
            weather = restTemplate.getForObject(url, WeatherDTO.class);
        } catch (HttpClientErrorException e) {
            throw new LocationNotFoundException();
        }

        return weather;
    }
}
