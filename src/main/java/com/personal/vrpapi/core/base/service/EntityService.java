package com.personal.vrpapi.core.base.service;

import com.personal.vrpapi.core.base.entity.AbstractEntity;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface EntityService {

    boolean isNew(AbstractEntity entity);

    <T extends AbstractEntity> List<T> search(Class<T> entity, Specification<T> specification);
}
