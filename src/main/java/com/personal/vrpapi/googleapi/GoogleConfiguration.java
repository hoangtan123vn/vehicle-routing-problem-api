package com.personal.vrpapi.googleapi;

import com.personal.vrpapi.googleapi.service.GoogleService;
import com.personal.vrpapi.googleapi.service.impl.GoogleServiceImpl;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(GoogleProperties.class)
public class GoogleConfiguration {

    @Bean
    public GoogleService googleService() {
        return new GoogleServiceImpl();
    }
}
