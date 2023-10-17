package com.personal.vrpapi;

import com.personal.vrpapi.core.authorization.enums.RoleEnum;
import com.personal.vrpapi.core.base.InitialSampleDataSetup;
import com.personal.vrpapi.core.base.initialdata.SampleData;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.*;

@Configuration
@EnableJpaAuditing(dateTimeProviderRef = "auditingDateTimeProvider")
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.personal.vrpapi.*"})
@EnableJpaRepositories(basePackages = {"com.personal.vrpapi.*"})
@EnableTransactionManagement(proxyTargetClass = true)
public class VrpApiConfiguration {

    @Bean
    public DateTimeProvider auditingDateTimeProvider() {
        return () -> Optional.of(ZonedDateTime.now().withZoneSameInstant(ZoneId.of(ZoneOffset.UTC.getId())));
    }

    @Bean
    public Map<RoleEnum, String> roleEnumMap(){
        EnumMap<RoleEnum, String> map = new EnumMap<>(RoleEnum.class);
        map.put(RoleEnum.ADMIN, "isAdmin");
        map.put(RoleEnum.CUSTOMER, "isCustomer");
        map.put(RoleEnum.DRIVER, "isDriver");
        return map;
    }

    @Bean
    public List<SampleData> sampleDataList() {
        return new ArrayList<>();
    }

    @Bean
    public InitialSampleDataSetup initialSampleDataSetup(@Qualifier("sampleDataList") List<SampleData> sampleDataList) {
        return new InitialSampleDataSetup(sampleDataList);
    }
}
