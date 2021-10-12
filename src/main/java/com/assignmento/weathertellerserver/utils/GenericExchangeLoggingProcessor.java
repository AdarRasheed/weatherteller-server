package com.assignmento.weathertellerserver.utils;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Proecessor to log any generic exchange in a custom defined fashion
 */
@Component
public class GenericExchangeLoggingProcessor implements Processor {

    private Logger logger = LoggerFactory.getLogger(GenericExchangeLoggingProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        logger.info("ExchangeLoggingProcessor: Received \"{}\" at {}", exchange.getMessage().getBody(), LocalDateTime.now());
    }
}
