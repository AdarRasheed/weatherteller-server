package com.assignmento.weathertellerserver.routes;

import com.assignmento.weathertellerserver.mappers.CurrentWeatherStampMapper;
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
    private CurrentWeatherStampMapper currentWeatherStampMapper;

    @Value("${weather.apiKey}")
    private String weatherApiKey;

    @Value("${weather.delay.timeUnit}")
    private String timeUnit;

    @Value("${weather.delay.initial}")
    private String initialDelay;

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
