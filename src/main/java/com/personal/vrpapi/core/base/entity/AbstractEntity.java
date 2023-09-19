package com.personal.vrpapi.core.base.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.util.ProxyUtils;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Optional;

@MappedSuperclass
@FieldNameConstants
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
public abstract class AbstractEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

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

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        if (!getClass().equals(ProxyUtils.getUserClass(obj))) {
            return false;
        }

        final AbstractEntity that = (AbstractEntity) obj;
        return Optional.ofNullable(getId()).map(objId -> objId.equals(that.getId())).orElse(false);
    }

    @Override
    public String toString() {
        return String.format("%s (<unsaved>)", this.getClass().getSimpleName());
    }
}