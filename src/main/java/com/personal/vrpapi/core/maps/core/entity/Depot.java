package com.personal.vrpapi.core.maps.core.entity;

import com.personal.vrpapi.core.base.entity.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
@Table(name = "depots")
@FieldNameConstants
public class Depot extends AbstractEntity {

    @Column
    private Double lat;

    @Column
    private Double lng;

    @Column
    private String line1;

    @Column
    private String line2;

    @Column
    private String hotLine;

    @Column
    private String district;

    @Column
    private String city;

    @Column
    private String country;

    @Column
    private String postalCode;

    @Column
    private String email;

    @OneToMany(mappedBy = Vehicle.Fields.depot, fetch = FetchType.LAZY)
    private List<Vehicle> vehicles;

    @Override
    public boolean equals(final Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
