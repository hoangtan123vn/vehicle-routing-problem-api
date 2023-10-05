package com.personal.vrpapi.core.maps.core.entity;

import com.personal.vrpapi.core.base.entity.AbstractNode;
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
public class Depot extends AbstractNode {

    @OneToMany(mappedBy = Vehicle.Fields.depot, fetch = FetchType.LAZY)
    private List<Vehicle> vehicles;

    @Column
    private Double capacityDepot;

    @Override
    public boolean equals(final Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
