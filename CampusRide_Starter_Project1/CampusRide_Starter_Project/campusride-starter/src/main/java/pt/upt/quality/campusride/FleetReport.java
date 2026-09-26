package pt.upt.quality.campusride;

import java.util.ArrayList;
import java.util.List;

public class FleetReport {
    private final Fleet fleet;

    public FleetReport(Fleet fleet) {
        this.fleet = fleet;
    }

    public List<String> availableVehicleIds() {
        List<String> availableIds = new ArrayList<>();
        for (Vehicle vehicle : fleet.getVehicles()) {
            if (vehicle.isAvailable()) {
                availableIds.add(vehicle.getId());
            }
        }
        return availableIds;
    }

    public double estimateTotalPrice(int minutes) {
        double priceTotal = 0.0;
        for (Vehicle vehicle : fleet.getVehicles()) {
            priceTotal += vehicle.calculatePrice(minutes);
        }
        return priceTotal;
    }

    public int countAvailableVehicles() {
        int count = 0;
        for (Vehicle vehicle : fleet.getVehicles()) {
            if (vehicle.isAvailable()) {
                count = count + 1;
            }
        }
        return count;
    }
}
