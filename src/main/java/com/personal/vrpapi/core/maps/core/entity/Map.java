package com.personal.vrpapi.core.maps.core.entity;

import com.personal.vrpapi.core.authorization.entity.Customer;
import com.personal.vrpapi.core.base.entity.AbstractEntity;
import com.personal.vrpapi.core.maps.core.enums.MapType;
import com.personal.vrpapi.core.maps.core.listener.MapListener;
import com.personal.vrpapi.core.maps.route.entity.Route;
import lombok.*;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
@Table(name = "maps", uniqueConstraints = {@UniqueConstraint(columnNames = {Map.Fields.mapId}, name = "mapId")})
@FieldNameConstants
@EntityListeners({MapListener.class})
@Builder
public class Map extends AbstractEntity {

    @Column
    private String mapId;

    @Column
    private Boolean isActive;

    @Column
    @Enumerated(EnumType.STRING)
    private MapType mapType;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "map_2_customer", joinColumns = @JoinColumn(name = "map_id"), inverseJoinColumns = @JoinColumn(name = "customer_id"))
    private List<Customer> customers;

    @OneToMany(mappedBy = Route.Fields.map, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Route> routes;

    @OneToOne(fetch = FetchType.LAZY)
    private Depot depot;

    @OneToMany(mappedBy = Vehicle.Fields.map, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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
