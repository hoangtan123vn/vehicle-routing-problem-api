package com.personal.vrpapi.core.maps.core.dto.model;

import com.personal.vrpapi.core.maps.core.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@AllArgsConstructor
@Data
public class Solution {

    private double cost;

    private ArrayList<Vehicle> vehicles;

    public Solution() {
        this.vehicles = new ArrayList<>();
        this.cost = 0;
    }
    public static Solution cloneSolution(Solution solution) {
        Solution out = new Solution();
        out.setCost(solution.getCost());
        out.setVehicles((ArrayList<Vehicle>) solution.getVehicles().clone());
        return out;
    }
}
