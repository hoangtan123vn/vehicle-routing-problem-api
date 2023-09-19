package com.personal.vrpapi.core.base.service.impl;

import com.personal.vrpapi.core.base.entity.AbstractEntity;
import com.personal.vrpapi.core.base.exception.BaseException;
import com.personal.vrpapi.core.base.repository.CommonRepository;
import com.personal.vrpapi.core.base.service.EntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.support.Repositories;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.Id;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class EntityServiceImpl implements EntityService {

    private static final Logger logger = LoggerFactory.getLogger(EntityServiceImpl.class);
    private final Map<String, CommonRepository<? extends AbstractEntity>> repositoryMap = new HashMap<>();
    private final EntityManager entityManager;

    private final Repositories repositories;

    public EntityServiceImpl(EntityManager entityManager, Repositories repositories) {
        this.entityManager = entityManager;
        this.repositories = repositories;
    }

    @Override
    public boolean isNew(AbstractEntity entity) {
        Field[] fields = entity.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Id.class)) {
                try {
                    Object value = field.get(entity);
                    return value == null;
                } catch (IllegalAccessException e) {
                    logger.error(e.getMessage());
                }
            }
        }
        return true;
    }

    @Override
    public <T extends AbstractEntity> List<T> search(Class<T> entity, Specification<T> specification) {
        Assert.notNull(entity, "entity must not be null");
        Assert.notNull(specification, "specification must not be null");
        return getRepository(entity).findAll(specification);
    }

    @Override
    public <T extends AbstractEntity> Page<T> searchPaging(Class<T> entity, Specification<T> specification, Pageable pageable) {
        Assert.notNull(entity, "entity must not be null");
        Assert.notNull(specification, "specification must not be null");
        Assert.notNull(pageable, "pageable must not be null");
        return getRepository(entity).findAll(specification, pageable);
    }

    @Override
    public <T extends AbstractEntity> T findById(Long id, Class<T> entity) {
        Assert.notNull(id, "id must not be null");
        Assert.notNull(entity, "entity must not be null");
        return entityManager.find(entity, id);
    }

    @SuppressWarnings("unchecked")
    private <T extends AbstractEntity> CommonRepository<T> getRepository(final Class<T> entity) {
        CommonRepository<T> repository = (CommonRepository<T>) repositoryMap.get(entity.getName());
        if (Objects.isNull(repository)) {
            repository = repositories.getRepositoryFor(entity).map(CommonRepository.class::cast)
                    .orElseThrow(() -> new BaseException(String.format("No repository found for entity %s", entity.getName())));
            repositoryMap.put(entity.getName(), repository);
            return repository;
        }
        return repository;
    }
}
