package com.weather.api.rest.params;

import org.apache.commons.text.WordUtils;
import org.springframework.stereotype.Component;

import java.text.Normalizer;

@Component
public class ParamsFormatHandling implements ParamsFormat {

    @Override
    public String fixformat(String params) {
        params = Normalizer.normalize(params, Normalizer.Form.NFD);
        params = params.replaceAll("[^\\p{ASCII}]", "");

        String[] parts = params.split(",");

        String result;

        if (parts.length >= 1) {
            String local = WordUtils.capitalizeFully(parts[0]);

            if (parts.length == 1)
                result = local;
            else
                result = local + "," + parts[1];
        } else {
            return null;
        }

        return result;
    }
}
