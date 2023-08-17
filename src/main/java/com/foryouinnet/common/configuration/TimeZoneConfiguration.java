package com.foryouinnet.common.configuration;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.TimeZone;

@Configuration
public class TimeZoneConfiguration {

    @Value("${server.timeZone}")
    private String timeZone;

    @PostConstruct
    public void configure() {
        TimeZone.setDefault(TimeZone.getTimeZone(timeZone));
    }
}
