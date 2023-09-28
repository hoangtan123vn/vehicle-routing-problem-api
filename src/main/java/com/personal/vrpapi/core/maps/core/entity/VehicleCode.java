package com.personal.vrpapi.core.maps.core.entity;

import com.personal.vrpapi.core.base.identifier.StringPrefixedSequenceIdGenerator;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class VehicleCode {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehicle_code_sequence")
    @GenericGenerator(
            name = "vehicle_code_sequence",
            strategy = "com.personal.vrpapi.core.base.identifier.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "50"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "VEH-"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%09d") })
    private String id;
}
