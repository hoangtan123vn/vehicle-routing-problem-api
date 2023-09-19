package com.personal.vrpapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.personal.vrpapi.*"})
@EnableJpaRepositories(basePackages = {"com.personal.vrpapi.*"})
public class VrpApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(VrpApiApplication.class, args);
    }

}
    