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
    private String lat;

    @Column
    private String lng;

    @Column
    private String address;

    @Column
    private String hotline;

    @Column
    private String postalCode;

    @Column
    private String email;

    @OneToMany(mappedBy = Vehicle.Fields.depot, fetch = FetchType.LAZY)
    private List<Vehicle> vehicles;
}
