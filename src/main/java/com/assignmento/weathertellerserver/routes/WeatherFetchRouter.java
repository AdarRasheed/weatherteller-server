package com.assignmento.weathertellerserver.routes;

import com.assignmento.weathertellerserver.utils.CustomLoggerUtil;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WeatherFetchRouter extends RouteBuilder {

    @Autowired
    private CustomLoggerUtil timeUtil;

    @Value("${weather.apiKey}")
    private String weatherApiKey;

    @Value("${weather.fetchDelayMs}")
    private String weatherFetchDelayMs;

    @Override
    public void configure() throws Exception {
        String endPoint = "weather://weather?"
                + "location=Lahore,Pakistan"
                + "&units=metric"
                + "&delay=" + weatherFetchDelayMs
                + "&appid=" + weatherApiKey;
        from(endPoint)
//                .log("${body}")
                .bean(timeUtil, "logReceivedMessage")
                .to("log:weather");
    }

}
