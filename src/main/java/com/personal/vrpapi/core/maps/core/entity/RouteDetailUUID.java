package com.personal.vrpapi.core.maps.core.entity;

import com.personal.vrpapi.core.base.identifier.StringPrefixedSequenceIdGenerator;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "route_detail_uuid")
public class RouteDetailUUID {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detail_uuid")
    @GenericGenerator(
            name = "detail_uuid",
            strategy = "com.personal.vrpapi.core.base.identifier.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "50"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "ROUTE_DETAIL-"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
    private String id;
}
