package com.personal.vrpapi.googleapi;

import com.personal.vrpapi.googleapi.service.GoogleService;
import com.personal.vrpapi.googleapi.service.impl.GoogleServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@RequiredArgsConstructor
public class GoogleConfiguration {

    @Bean
    public GoogleService googleService() {
        return new GoogleServiceImpl();
    }
}
