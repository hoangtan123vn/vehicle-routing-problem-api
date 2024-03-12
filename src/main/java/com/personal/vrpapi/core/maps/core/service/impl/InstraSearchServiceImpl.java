package com.personal.vrpapi.core.maps.core.service.impl;

import com.personal.vrpapi.core.base.entity.AbstractNode;
import com.personal.vrpapi.core.maps.core.converter.RouteConverter;
import com.personal.vrpapi.core.maps.core.entity.Depot;
import com.personal.vrpapi.core.maps.core.entity.Vehicle;
import com.personal.vrpapi.core.maps.core.enums.VehicleType;
import com.personal.vrpapi.core.maps.core.service.SearchService;
import com.personal.vrpapi.core.maps.core.service.VehicleService;
import com.personal.vrpapi.core.maps.route.entity.Route;
import com.personal.vrpapi.core.maps.route.entity.RouteDetail;
import com.personal.vrpapi.core.maps.route.service.RouteDetailService;
import com.personal.vrpapi.core.maps.route.service.RouteService;
import com.personal.vrpapi.googleapi.service.GoogleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InstraSearchServiceImpl implements SearchService {


    private final GoogleService googleService;

    private final RouteConverter routeConverter;

    private final RouteService routeService;

    private final VehicleService vehicleService;

    private final RouteDetailService routeDetailService;

    @Override
    @Transactional
    public List<Route> search(List<RouteDetail> routeDetails, Depot depot, com.personal.vrpapi.core.maps.core.entity.Map map, VehicleType type) {
        List<Route> routes = new ArrayList<>();
        List<Vehicle> vehicles = vehicleService.findAllByDepotAndFreeWithType(depot, type);
        for (Vehicle vehicle : vehicles) {
            Route route = buildRouteforVehicle(routeDetails, depot, map, vehicle);
            routeService.save(route);
            routes.add(route);
        }

        return routes;
    }

    private Route buildRouteforVehicle(List<RouteDetail> routeDetails, Depot depot,
                                       com.personal.vrpapi.core.maps.core.entity.Map map, Vehicle vehicle) {
        List<AbstractNode> nodes = new ArrayList<>();
        nodes.add(depot);
        double capacity = vehicle.getCapacity();
        double loading = 0.0;
        double costRoute = 0.0;
        int notInserted = routeDetails.size();

        boolean isFinal = (notInserted == 0);
        if (isFinal) {
            nodes.add(depot);
        }

        while (!isFinal) {
            int positionOfTheNextOne = -1;
            Double bestCostForTheNextOne = Double.MAX_VALUE;
            AbstractNode lastInTheRoute = nodes.get(nodes.size() - 1);

            for (RouteDetail routeDetail : routeDetails) {
                if (Boolean.FALSE.equals(routeDetail.getIsRouted())) {
                    Double trialCost = googleService.
                            getValueSingleDistance(lastInTheRoute instanceof Depot
                                    ? lastInTheRoute.getAddress()
                                    : ((RouteDetail) lastInTheRoute).getShippingAddress(), routeDetail.getShippingAddress());
                    if (trialCost < bestCostForTheNextOne && routeDetail.getDemand() <= capacity) {
                        positionOfTheNextOne = routeDetails.indexOf(routeDetail);
                        bestCostForTheNextOne = trialCost;
                    }
                }
            }

            if (positionOfTheNextOne != -1) {
                RouteDetail node = routeDetails.get(positionOfTheNextOne);
                nodes.add(node);
                capacity -= node.getDemand();
                loading += node.getDemand();
                costRoute += bestCostForTheNextOne;
                node.setIsRouted(true);
                notInserted -= 1;
                routeDetailService.save(node);
            } else {
                nodes.add(depot);
                costRoute += googleService.getValueSingleDistance(lastInTheRoute instanceof RouteDetail routeDetail ? routeDetail.getShippingAddress() : lastInTheRoute.getAddress(), depot.getAddress());
                isFinal = true;
            }
        }

        return routeConverter.buildRoute(costRoute, loading, nodes, map, vehicle);
    }
}
