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

public abstract class AbstractGoogleService {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractGoogleService.class);

    protected Response executeRequest(final String endpoint, final RequestBody requestBody,
                                      final HttpMethod httpMethod) {
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url(endpoint)
                    .method(httpMethod.toString(), requestBody)
                    .build();
            return client.newCall(request).execute();
        } catch (Exception exception) {
            throw new ApiCommunicationException(exception.getMessage());
        }
    }

    protected <T> T readValue(Class<T> target, Response response) {
        if (response.isSuccessful() && response.body() != null) {
            try {
                String responseBody = response.body().string();
                return objectMapper.readValue(responseBody, target);
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
                e.printStackTrace();
            }
        }
        return null;
    }
}
