package com.personal.vrpapi.core.base.service;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.personal.vrpapi.googleapi.exception.ApiCommunicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Objects;

public abstract class AbstractService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractService.class);

    @Autowired
    private RestTemplate REST_TEMPLATE;

    @Autowired
    private ObjectMapper OBJECT_MAPPER;

    protected <T, R> T executeGetRequest(Class<T> clazz, final String endpoint, final HttpHeaders headers) {
        return executeRequest(clazz, endpoint, null, HttpMethod.GET, headers);
    }

    protected <T, R> T executeGetRequest(Class<T> clazz, final String endpoint, final R request, final HttpHeaders headers) {
        return executeRequest(clazz, endpoint, request, HttpMethod.GET, headers);
    }

    protected <T, R> T executePostRequest(Class<T> clazz, final String endpoint, final R request,
                                          final HttpHeaders headers) {
        return executeRequest(clazz, endpoint, request, HttpMethod.POST, headers);
    }

    protected <T, R> T executePutRequest(Class<T> clazz, final String endpoint, final R request,
                                         final HttpHeaders headers) {
        return executeRequest(clazz, endpoint, request, HttpMethod.PATCH, headers);
    }

    protected <T, R> T executeDeleteRequest(Class<T> clazz, final String endpoint,
                                            final R request, final HttpHeaders headers) {
        return executeRequest(clazz, endpoint, request, HttpMethod.DELETE, headers);
    }

    private <T, R> T executeRequest(Class<T> clazz, final String endpoint, final R requestBody,
                                    final HttpMethod httpMethod, final HttpHeaders headers) {
        ResponseEntity<T> response;
        try {
            HttpEntity<?> entity;
            if (Objects.nonNull(requestBody)) {
                entity = new HttpEntity<>(requestBody, headers);
            } else {
                entity = new HttpEntity<>(headers);
            }
            logRequest(httpMethod.name(), endpoint, requestBody);
            response = REST_TEMPLATE.exchange(endpoint,
                    httpMethod, entity, clazz);
        } catch (Exception exception) {
            throw new ApiCommunicationException(exception.getMessage());
        }
        return response.getBody();
    }

    private <T> T readValue(ResponseEntity<String> response, JavaType javaType) {
        T result = null;
        if (response.getStatusCode() == HttpStatus.OK ||
                response.getStatusCode() == HttpStatus.CREATED) {
            try {
                result = OBJECT_MAPPER.readValue(response.getBody(), javaType);
            } catch (IOException e) {
                LOGGER.error(e.getMessage());
            }
        } else {
            LOGGER.info("Error with  {}", response.getStatusCode());
        }
        return result;
    }

    private void logRequest(final Object method, final Object uri, final Object payload) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("{} {} {}", method, uri, payload);
        }
    }
}