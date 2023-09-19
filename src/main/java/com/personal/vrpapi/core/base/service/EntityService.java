package com.personal.vrpapi.core.base.service;

import com.personal.vrpapi.core.base.entity.AbstractEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface EntityService {

    /**
     * check entity is New
     * return true if is new, false if is not new
     * @param entity
     * @return
     */
    boolean isNew(AbstractEntity entity);

    /**
     * execute get list entity with entity params and specification
     * @param entity
     * @param specification
     * @return
     * @param <T>
     */
    <T extends AbstractEntity> List<T> search(Class<T> entity, Specification<T> specification);

    /**
     * execute get list entity with entity params, specifications, paging
     * @param entity
     * @param specification
     * @param pageable
     * @return
     * @param <T>
     */
    <T extends AbstractEntity> Page<T> searchPaging(Class<T> entity, Specification<T> specification, Pageable pageable);

    /**
     * find entity by ID
     * @param id
     * @param entity
     * @return
     * @param <T>
     */
    <T extends AbstractEntity> T findById(Long id, Class<T> entity);
}
