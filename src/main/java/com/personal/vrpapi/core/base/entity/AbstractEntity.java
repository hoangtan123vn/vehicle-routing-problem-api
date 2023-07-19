package com.personal.vrpapi.core.base.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.ZonedDateTime;

@MappedSuperclass
@FieldNameConstants
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String lastModifiedBy;

    @Column
    @LastModifiedDate
    private ZonedDateTime lastModifiedDate;

    @Column
    @CreatedDate
    private ZonedDateTime createdAt;
}