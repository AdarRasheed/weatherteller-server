package com.assignmento.weathertellerserver.mappers;

import com.assignmento.weathertellerserver.models.WeatherStamp;
import com.assignmento.weathertellerserver.utils.CurrentWeatherDeserializer;
import com.google.gson.GsonBuilder;
import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

/**
 * Transforms current weather record polled from openweather.org platform to current weather-stamp model
 */
@Component
public class CurrentWeatherStampMapper {

    /**
     * Call this function to to map polled current weather update to system model
     *
     * @param exchange polled from openweather.org platform for current weather api
     * @return the {@link WeatherStamp} entity model
     *
     */
    public WeatherStamp mapToWeatherStamp(Exchange exchange) {
        String json = exchange.getMessage().getBody().toString();

        GsonBuilder gsonBldr = new GsonBuilder();
        gsonBldr.registerTypeAdapter(WeatherStamp.class, new CurrentWeatherDeserializer());
        return gsonBldr.create().fromJson(json, WeatherStamp.class);
    }

}
