package com.personal.vrpapi.core.base;

import com.personal.vrpapi.core.base.initialdata.SampleData;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InitialSampleDataPostProcessor implements BeanPostProcessor, BeanFactoryAware {

    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof SampleData sampleData) {
            List<SampleData> sampleDataList = beanFactory.getBean("sampleDataList", List.class);
            sampleDataList.add(sampleData);
        }
        return bean;
    }
}
