package com.personal.vrpapi.core.base;

import com.personal.vrpapi.core.base.service.EntityService;
import com.personal.vrpapi.core.base.service.impl.EntityServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.support.Repositories;

import javax.annotation.Resource;
import javax.persistence.EntityManager;

@Configuration
public class PersistentConfiguration {

    @Resource
    ApplicationContext applicationContext;

    @Bean
    public Repositories repositories() {
        return new Repositories(applicationContext);
    }

    @Bean
    public EntityService entityService(final EntityManager entityManager, final Repositories repositories) {
        return new EntityServiceImpl(entityManager, repositories);
    }
}
