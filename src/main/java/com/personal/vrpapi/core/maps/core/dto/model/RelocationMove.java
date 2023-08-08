package com.personal.vrpapi.core.maps.core.dto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RelocationMove
{
    // From which route we remove the customer
    private int fromRoute;

    // To which route we insert the customer
    private int toRoute;

    // In which position (of the initial route) we find the customer we want to relocate
    private int positionOfRelocated;

    // In which position (of the new route) we want to insert the customer
    private int positionToBeInserted;

    // Move Cost for the route from which we remove a customer
    private long fromMoveCost;

    // Move Cost for the route to which we add a customer
    private long toMoveCost;

    // Total move cost = fromMoveCost + toMoveCost
    private long moveCost;

    // Updated load for the route from which we remove a customer
    private  int fromUpdLoad;

    // Updated load for the route to which we insert a customer
    private int toUpdLoad;
}