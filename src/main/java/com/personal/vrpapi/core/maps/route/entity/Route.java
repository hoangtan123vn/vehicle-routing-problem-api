package com.personal.vrpapi.core.maps.route.entity;

import com.personal.vrpapi.core.base.entity.AbstractEntity;
import com.personal.vrpapi.core.maps.core.entity.Map;
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
@Table(name = "routes")
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
}
