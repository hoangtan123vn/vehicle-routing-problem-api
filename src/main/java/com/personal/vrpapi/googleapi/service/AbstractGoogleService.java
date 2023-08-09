package com.personal.vrpapi.googleapi.service;

import com.personal.vrpapi.googleapi.exception.ApiCommunicationException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.springframework.http.HttpMethod;

public abstract class AbstractGoogleService {

    private ResponseBody executeRequest(final String endpoint, final RequestBody requestBody,
                                    final HttpMethod httpMethod) {
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url(endpoint)
                    .method(httpMethod.toString(), requestBody)
                    .build();
            return client.newCall(request).execute().body();
        } catch (Exception exception) {
            throw new ApiCommunicationException(exception.getMessage());
        }
    }
}
