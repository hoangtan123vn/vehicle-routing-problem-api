package com.personal.vrpapi.core.authorization.entity;

import com.personal.vrpapi.core.base.entity.AbstractUser;
import com.personal.vrpapi.core.maps.route.entity.RouteDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
public class Customer extends AbstractUser {

    @Column
    private String shippingAddress;

    @OneToMany(mappedBy = RouteDetail.Fields.customer, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<RouteDetail> routeDetails;
}