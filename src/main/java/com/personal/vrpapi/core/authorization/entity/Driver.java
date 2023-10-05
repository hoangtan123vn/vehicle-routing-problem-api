package com.personal.vrpapi.core.authorization.entity;

import com.personal.vrpapi.core.base.entity.AbstractUser;
import com.personal.vrpapi.core.maps.core.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Driver extends AbstractUser {

    @Column
    @Enumerated(EnumType.STRING)
    private StatusDriver status;

    @OneToOne(mappedBy = Vehicle.Fields.driver, fetch = FetchType.LAZY)
    private Vehicle vehicle;

    @Override
    public boolean equals(final Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}