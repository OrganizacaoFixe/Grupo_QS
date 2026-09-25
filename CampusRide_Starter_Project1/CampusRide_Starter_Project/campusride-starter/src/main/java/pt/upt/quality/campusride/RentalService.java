package pt.upt.quality.campusride;

public class RentalService {
    private final Fleet fleet;

    public RentalService(Fleet fleet) {
        this.fleet = fleet;
    }

    public void rentVehicle(String id) {
        Vehicle vehicle = getVehicleOrThrow(id);
        vehicle.rent();
    }

    public void returnVehicle(String id) {
        Vehicle vehicle = getVehicleOrThrow(id);
        vehicle.returnVehicle();
    }

    public double estimatePrice(String id, int minutes) {
        Vehicle vehicle = getVehicleOrThrow(id);
        return vehicle.calculatePrice(minutes);
    }

    private Vehicle getVehicleOrThrow(String id) {
        Vehicle vehicle = fleet.findById(id);
        if (vehicle == null) {
            throw new IllegalArgumentException("Veículo não encontrado com o ID: " + id);
        }
        return vehicle;
    }
}