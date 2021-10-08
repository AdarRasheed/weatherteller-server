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

    @Override
    public void configure() throws Exception {
        String endPoint = "weather://weather-fetcher"
                            + "?location=" + "Madrid,Spain"
                            + "&delay=" + "1000"
                            + "&appid=" + "aa67371fffed03e5964428e6c7d83927";
        from(endPoint)
//                .log("${body}")
                .bean(timeUtil, "logReceivedMessage")
                .to("log:weather-fetcher");
    }

}
