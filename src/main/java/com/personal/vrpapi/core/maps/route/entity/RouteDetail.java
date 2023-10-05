package com.personal.vrpapi.core.maps.route.entity;

import com.personal.vrpapi.core.authorization.entity.Customer;
import com.personal.vrpapi.core.authorization.entity.Driver;
import com.personal.vrpapi.core.base.entity.AbstractNode;
import com.personal.vrpapi.core.maps.core.entity.Map;
import com.personal.vrpapi.core.maps.core.listener.RouteDetailListener;
import com.personal.vrpapi.core.maps.route.enums.StatusRoute;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "route_detail", uniqueConstraints = {
        @UniqueConstraint(columnNames = {RouteDetail.MAP_ID, RouteDetail.CUSTOMER_ID})
})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldNameConstants
@EntityListeners(value = RouteDetailListener.class)
public class RouteDetail extends AbstractNode {

    public static final String ROUTE_ID = "route_id";
    public static final String DRIVER_ID = "driver_id";
    public static final String MAP_ID = "map_id";
    public static final String CUSTOMER_ID = "customer_id";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = DRIVER_ID)
    private Driver driver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = CUSTOMER_ID)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = ROUTE_ID)
    private Route route;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = MAP_ID)
    private Map map;

    @Column
    private String routeDetailUUID;

    @Column
    private String shippingAddress;

    @Column
    private Long sequence;

    @Column
    private Double demand;

    @Column
    @Enumerated(EnumType.STRING)
    private StatusRoute statusRoute;

    @Column
    private Boolean isShipped;

    @Column
    private ZonedDateTime dateCompleted;

    @Column
    private Boolean isRouted;

    @Override
    public boolean equals(final Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
