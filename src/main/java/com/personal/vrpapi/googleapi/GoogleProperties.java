package com.personal.vrpapi.googleapi;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;

@Data
@Component
//@PropertySource("classpath:google.yml")
@ConfigurationProperties(prefix = "googleapi")
public class GoogleProperties {

    @NotBlank
    private String url;

    @NotBlank
    private String apikey;
}
