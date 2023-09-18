package com.personal.vrpapi.core.base.repository;

import com.personal.vrpapi.core.base.entity.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CommonRepository<T extends AbstractEntity> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {
}
