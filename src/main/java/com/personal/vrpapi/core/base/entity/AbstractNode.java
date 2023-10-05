package com.personal.vrpapi.core.base.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@FieldNameConstants
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
public abstract class AbstractNode extends AbstractEntity {

    @Column
    private Double lat;

    @Column
    private Double lng;

    @Column
    private String postalCode;

    @Column
    private String address;

    @Column
    private String email;

    @Column
    private String country;

    @Column
    private String hotLine;

    @Override
    public boolean equals(final Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
