package com.personal.vrpapi.core.maps.route.entity;

import com.personal.vrpapi.core.base.entity.AbstractEntity;
import com.personal.vrpapi.core.maps.core.entity.Map;
import com.personal.vrpapi.core.maps.core.entity.Vehicle;
import com.personal.vrpapi.core.maps.route.enums.StatusRoute;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table(name = "routes", uniqueConstraints = {
        @UniqueConstraint(
                columnNames = {
                        Route.Fields.map,
                        Route.Fields.vehicle})
})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldNameConstants
public class Route extends AbstractEntity {

    @Column
    private ZonedDateTime dateCompleted;

    @Column
    private Double costRoute;

    @Column
    private Double loadingRoute;

    @Column
    private Double capacityRoute;

    @Column
    @Enumerated(EnumType.STRING)
    private StatusRoute statusRoute;

    @OneToMany(mappedBy = RouteDetail.Fields.route, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<RouteDetail> routeDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "map_id")
    private Map map;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id")
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
