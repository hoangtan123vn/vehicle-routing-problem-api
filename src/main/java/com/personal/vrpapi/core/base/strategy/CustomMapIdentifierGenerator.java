package com.personal.vrpapi.core.base.strategy;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class CustomMapIdentifierGenerator implements IdentifierGenerator {
    private static final String mapPrefix = "MAP-";
    private static final String length = "%09d";
    private static int counter = 1;

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        String generatedId = mapPrefix+ String.format(length, counter);
        counter++;
        return generatedId;
    }
}
