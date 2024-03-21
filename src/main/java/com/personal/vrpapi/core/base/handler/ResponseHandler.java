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
import java.util.Collection;

@ControllerAdvice
public class ResponseHandler implements ResponseBodyAdvice<Object> {
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
                    .pageable(buildPageable(paging))
                    .build();
        }

        if (body instanceof Collection<?> collection) {
            return Response.builder()
                    .data(collection)
                    .timestamp(ZonedDateTime.now())
                    .pageable(buildDefaultPageable())
                    .build();
        }

        return Response.builder().data((Object) body).build();
    }

    private Pageable buildPageable(Page<?> page) {
        org.springframework.data.domain.Pageable pageable = page.getPageable();
        Pageable pageableDTO = new Pageable();
        pageableDTO.setPageSize(pageable.getPageSize());
        pageableDTO.setCurrentPage(pageable.getPageNumber());
        pageableDTO.setTotalPages(page.getTotalPages());
        pageableDTO.setTotalElements(page.getTotalElements());
        return pageableDTO;
    }

    private Pageable buildDefaultPageable() {
        Pageable pageableDTO = new Pageable();
        pageableDTO.setPageSize(0);
        pageableDTO.setCurrentPage(0);
        pageableDTO.setTotalPages(1);
        pageableDTO.setTotalElements(1);
        return pageableDTO;
    }
}
