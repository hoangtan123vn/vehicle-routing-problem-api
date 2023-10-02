package com.personal.vrpapi.core.maps.route.entity;

import com.personal.vrpapi.core.authorization.entity.Customer;
import com.personal.vrpapi.core.authorization.entity.Driver;
import com.personal.vrpapi.core.base.entity.AbstractEntity;
import com.personal.vrpapi.core.maps.route.enums.StatusRoute;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "route_detail")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldNameConstants
public class RouteDetail extends AbstractEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver")
    private Driver driver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer")
    private Customer customer;

    @Column
    private String shippingAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route")
    private Route route;

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
