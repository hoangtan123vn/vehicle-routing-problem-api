//package com.personal.vrpapi.core.base;
//
//import org.springframework.beans.BeansException;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.repository.support.Repositories;
//import org.springframework.data.util.Lazy;
//
//@Configuration
//public class RepositoryRestSupportConfiguration implements ApplicationContextAware {
//
//    private Lazy<Repositories> repositories;
//    private ApplicationContext context;
//
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        this.context = applicationContext;
//        this.repositories = Lazy.of(() -> context.getBean(Repositories.class));
//    }
//}
