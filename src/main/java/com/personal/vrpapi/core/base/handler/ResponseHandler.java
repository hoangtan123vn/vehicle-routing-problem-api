package com.personal.vrpapi.core.base.handler;

import com.personal.vrpapi.core.base.dto.ErrorMessage;
import com.personal.vrpapi.core.base.dto.Response;
import org.springframework.core.MethodParameter;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.time.ZonedDateTime;
import java.util.ArrayList;

@ControllerAdvice
public class ResponseHandler implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof ErrorMessage) {
            return body;
        }

        if (body instanceof Page<?> paging) {
            return Response.builder()
                    .data(paging.hasContent() ? paging.getContent() : new ArrayList<>())
                    .timestamp(ZonedDateTime.now())
                    .pageable(buildPageable(paging.getPageable()))
                    .build();
        }

        return Response.builder().data(body).build();
    }

    private Pageable buildPageable(org.springframework.data.domain.Pageable pageable) {
        Pageable page = new Pageable();
        page.setPageSize(pageable.getPageSize());
        page.setCurrentPage(pageable.getPageNumber());
        page.setTotalElements(pageable.getOffset());
        return page;
    }
}
