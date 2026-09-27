package pt.upt.quality.campusride;

public class EBike extends Bike implements Electric {

    private int batteryLevel;

    public EBike(String id, int batteryLevel) {
        super(id);

        if (batteryLevel < 0 || batteryLevel > 100) {
            throw new IllegalArgumentException(
                "Battery level must be between 0 and 100"
            );
        }

        this.batteryLevel = batteryLevel;
    }

    @Override
    public int getBatteryLevel() {
        return batteryLevel;
    }

    @Override
    public void charge(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(
                "Charge amount cannot be negative"
            );
        }

        batteryLevel = Math.min(100, batteryLevel + amount);
    }
}