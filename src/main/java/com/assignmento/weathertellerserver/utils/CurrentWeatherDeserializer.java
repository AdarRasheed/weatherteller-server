package com.assignmento.weathertellerserver.utils;

import com.assignmento.weathertellerserver.models.WeatherStamp;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Deserializes current weather json polled from openweather.org platform to current weather-stamp model
 */
public class CurrentWeatherDeserializer implements JsonDeserializer<WeatherStamp> {

    /**
     * Call this function to to deserialize polled current weather json picking only required attributes
     *
     * @return the {@link WeatherStamp} entity model
     *
     */
    @Override
    public WeatherStamp deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jObject = jsonElement.getAsJsonObject();

        Long cityOpenweatherId = jObject.get("id").getAsLong();
        Double temperature = jObject.get("main").getAsJsonObject().get("temp").getAsDouble();
        String weatherInfo = jObject.get("weather").getAsJsonArray().get(0).getAsJsonObject().get("main").getAsString();
        String recordedOn = new SimpleDateFormat("H:mm  dd MMM yy").format(new Date(jObject.get("dt").getAsInt()*1000));

        return new WeatherStamp(cityOpenweatherId, temperature, weatherInfo, recordedOn);
    }
}
