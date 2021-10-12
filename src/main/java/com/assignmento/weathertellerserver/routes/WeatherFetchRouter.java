package com.assignmento.weathertellerserver.routes;

import com.assignmento.weathertellerserver.mappers.CurrentWeatherStampMapper;
import com.assignmento.weathertellerserver.utils.GenericExchangeLoggingProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Camel router for polling in current weather periodically from openweather.org platform, and adding it to the in-memory H2 database
 */
@Component
public class WeatherFetchRouter extends RouteBuilder {

    @Autowired
    private GenericExchangeLoggingProcessor exchangeLoggingProcessor;

    @Autowired
    private CurrentWeatherStampMapper currentWeatherStampMapper;

    /** Represents openweather.org platform account current weather api key
     */
    @Value("${weather.apiKey}")
    private String weatherApiKey;

    /** Represents time unit to define initial and interval data poll delay
     */
    @Value("${weather.delay.timeUnit}")
    private String timeUnit;

    /** Represents initial delay for the router on server start
     */
    @Value("${weather.delay.initial}")
    private String initialDelay;

    /** Represents interval delay for the router between polls
     */
    @Value("${weather.delay.interval}")
    private String intervalDelay;

    private String cityName = "Lahore,Pakistan";

    @Override
    public void configure() throws Exception {
        String endPoint = "weather://current-weather-fetcher?"
                + "location=" + cityName
                + "&units=metric"
                + "&timeUnit=" + timeUnit
                + "&initialDelay=" + initialDelay
                + "&delay=" + intervalDelay
                + "&appid=" + weatherApiKey;
        from(endPoint)
                .process(exchangeLoggingProcessor)
                .bean(currentWeatherStampMapper, "mapToWeatherStamp")
                .log("${body}")
                .to("jpa:com.assignmento.weathertellerserver.models.WeatherStamp");
    }

}
