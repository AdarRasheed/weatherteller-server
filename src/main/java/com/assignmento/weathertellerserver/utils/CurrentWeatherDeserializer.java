package com.assignmento.weathertellerserver.utils;

import com.assignmento.weathertellerserver.models.WeatherStamp;
import com.google.gson.*;

import java.lang.reflect.Type;

public class CurrentWeatherDeserializer implements JsonDeserializer<WeatherStamp> {

    @Override
    public WeatherStamp deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jObject = jsonElement.getAsJsonObject();

        String cityName = jObject.get("name").getAsString();
        Double temperature = jObject.get("main").getAsJsonObject().get("temp").getAsDouble();
        String weatherInfo = jObject.get("weather").getAsJsonArray().get(0).getAsJsonObject().get("main").getAsString();
        String recordedOn = jObject.get("dt").getAsString();

        return new WeatherStamp(cityName, temperature, weatherInfo, recordedOn);
    }
}
