package com.personal.vrpapi.core.maps.core.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class MapCode {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "map_code_sequence")
    @GenericGenerator(
            name = "map_code_sequence",
            strategy = "com.personal.vrpapi.core.base.strategy.CustomMapIdentifierGenerator")
    private String id;
}
