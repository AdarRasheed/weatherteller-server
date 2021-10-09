package com.assignmento.weathertellerserver.mappers;

import com.assignmento.weathertellerserver.models.Weather;
import com.assignmento.weathertellerserver.utils.CurrentWeatherDeserializer;
import com.google.gson.GsonBuilder;
import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

@Component
public class CurrentWeatherMapper {

    public Weather mapToWeather(Exchange exchange) {
        String json = exchange.getMessage().getBody().toString();

        GsonBuilder gsonBldr = new GsonBuilder();
        gsonBldr.registerTypeAdapter(Weather.class, new CurrentWeatherDeserializer());
        return gsonBldr.create().fromJson(json, Weather.class);
    }

}
