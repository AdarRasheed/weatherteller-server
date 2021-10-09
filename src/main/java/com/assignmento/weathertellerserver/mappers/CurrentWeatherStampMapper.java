package com.assignmento.weathertellerserver.mappers;

import com.assignmento.weathertellerserver.models.WeatherStamp;
import com.assignmento.weathertellerserver.utils.CurrentWeatherDeserializer;
import com.google.gson.GsonBuilder;
import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

@Component
public class CurrentWeatherStampMapper {

    public WeatherStamp mapToWeatherStamp(Exchange exchange) {
        String json = exchange.getMessage().getBody().toString();

        GsonBuilder gsonBldr = new GsonBuilder();
        gsonBldr.registerTypeAdapter(WeatherStamp.class, new CurrentWeatherDeserializer());
        return gsonBldr.create().fromJson(json, WeatherStamp.class);
    }

}
