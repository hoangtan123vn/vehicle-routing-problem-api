package com.personal.vrpapi.core.maps.core.entity;

import com.personal.vrpapi.core.base.entity.AbstractEntity;
import com.personal.vrpapi.core.maps.core.enums.MapType;
import com.personal.vrpapi.core.maps.core.listener.MapListener;
import com.personal.vrpapi.core.maps.route.entity.Route;
import com.personal.vrpapi.core.maps.route.entity.RouteDetail;
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

    @OneToMany(mappedBy = Route.Fields.map, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Route> routes;

    @OneToOne(fetch = FetchType.LAZY)
    private Depot depot;

    @OneToMany(mappedBy = RouteDetail.Fields.map, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<RouteDetail> nodes;

    @Override
    public boolean equals(final Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
