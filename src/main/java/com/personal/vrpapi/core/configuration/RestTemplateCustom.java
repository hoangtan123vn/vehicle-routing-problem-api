package com.personal.vrpapi.core.configuration;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.task.AsyncListenableTaskExecutor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateCustom {

    @Value("${resttemplate.connect.timeout}")
    private static int connectTimeout;

    @Value("${resttemplate.read.timeout}")
    private static int readTimeout;

    @Value("${resttemplate.connection.pool}")
    private static int pool;

    @Bean
    @Primary
    public RestTemplate customRestTemplate()
    {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(connectTimeout);
        requestFactory.setReadTimeout(readTimeout);
        requestFactory.setTaskExecutor(taskExecutor());
        return new RestTemplate(requestFactory);
    }

    private AsyncListenableTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(pool);
        executor.setQueueCapacity(200);
        executor.setThreadNamePrefix("task_executor_thread");
        return executor;
    }
}
