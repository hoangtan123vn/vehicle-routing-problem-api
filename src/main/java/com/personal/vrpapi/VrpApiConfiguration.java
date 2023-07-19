package com.personal.vrpapi;

import com.personal.vrpapi.core.authorization.enums.RoleEnum;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

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
}
