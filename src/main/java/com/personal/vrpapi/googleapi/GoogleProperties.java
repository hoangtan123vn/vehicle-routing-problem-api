package com.personal.vrpapi.googleapi;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
//@PropertySource("classpath:google.yml")
@ConfigurationProperties(prefix = "googleapi")
public class GoogleProperties {

    private String url;

    private String apiKey;
}
