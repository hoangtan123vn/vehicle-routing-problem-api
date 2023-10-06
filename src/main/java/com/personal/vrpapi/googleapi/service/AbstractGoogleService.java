package com.personal.vrpapi.googleapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.personal.vrpapi.googleapi.exception.ApiCommunicationException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;

import java.util.Objects;

public abstract class AbstractGoogleService {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractGoogleService.class);

    protected <T> T executeRequest(final String endpoint, final RequestBody requestBody,
                                      final HttpMethod httpMethod, final Class<T> clazz) {
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url(endpoint)
                    .method(String.valueOf(httpMethod), requestBody)
                    .build();
            LOGGER.info("SEND API GOOGLE REQUEST {}", requestBody);
            Response response = client.newCall(request).execute();
            LOGGER.info("SEND API GOOGLE RESPONSE {}", response);
            if (response.isSuccessful()) {
                T t = readValue(clazz, response);
                if (Objects.nonNull(t)) {
                    return t;
                }
            }
            throw new ApiCommunicationException("Api communicate exception" + response.message());

        } catch (Exception exception) {
            throw new ApiCommunicationException("Api communicate exception" + exception.getMessage());
        }
    }

    protected <T> T readValue(Class<T> target, Response response) {
        if (response.isSuccessful() && response.body() != null) {
            try {
                String responseBody = response.body().string();
                return objectMapper.readValue(responseBody, target);
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
            }
        }
        return null;
    }
}
