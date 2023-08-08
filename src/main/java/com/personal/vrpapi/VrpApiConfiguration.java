package com.personal.vrpapi;

import com.personal.vrpapi.core.authorization.enums.RoleEnum;
import com.personal.vrpapi.core.base.InitialSampleDataSetup;
import com.personal.vrpapi.core.base.initialdata.SampleData;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.task.AsyncListenableTaskExecutor;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.*;

@Configuration
@EnableJpaAuditing(dateTimeProviderRef = "auditingDateTimeProvider")
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
