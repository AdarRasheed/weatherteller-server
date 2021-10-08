package com.assignmento.weathertellerserver.utils;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CustomLoggerUtil {

    private Logger logger = LoggerFactory.getLogger(CustomLoggerUtil.class);

    public void logReceivedMessage(Exchange exchange) {
        logger.info("Message Received as \"{}\" at {}", exchange.getMessage().getBody(), LocalDateTime.now());
    }
}
