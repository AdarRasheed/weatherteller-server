package com.assignmento.weathertellerserver.routes;

import com.assignmento.weathertellerserver.mappers.CurrentWeatherMapper;
import com.assignmento.weathertellerserver.utils.GenericExchangeLoggingProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WeatherFetchRouter extends RouteBuilder {

    @Autowired
    private GenericExchangeLoggingProcessor exchangeLoggingProcessor;

    @Autowired
    private CurrentWeatherMapper currentWeatherMapper;

    @Value("${weather.apiKey}")
    private String weatherApiKey;

    @Value("${weather.fetchDelayMs}")
    private String weatherFetchDelayMs;

    private String cityName = "Lahore,Pakistan";

    @Override
    public void configure() throws Exception {
        String endPoint = "weather://current-weather-fetcher?"
                + "location=" + cityName
                + "&units=metric"
                + "&delay=" + weatherFetchDelayMs
                + "&appid=" + weatherApiKey;
        from(endPoint)
                .process(exchangeLoggingProcessor)
                .bean(currentWeatherMapper, "mapToWeather")
                .log("${body}")
                .to("log:current-weather-fetcher");
    }

}
