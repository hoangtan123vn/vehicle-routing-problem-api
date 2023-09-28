package com.personal.vrpapi.core.maps.core.entity;

import com.personal.vrpapi.core.authorization.entity.Driver;
import com.personal.vrpapi.core.base.entity.AbstractEntity;
import com.personal.vrpapi.core.maps.core.enums.VehicleType;
import com.personal.vrpapi.core.maps.core.listener.VehicleListener;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
@Table(name="vehicles")
@EntityListeners({VehicleListener.class})
@FieldNameConstants
public class Vehicle extends AbstractEntity {

    @Column
    private Double capacity;

    @Column
    private String vehicleId;

    @Column
    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    @OneToOne
    @JoinColumn(name = "driver")
    private Driver driver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Depot depot;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Map map;

    @Override
    public boolean equals(final Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}