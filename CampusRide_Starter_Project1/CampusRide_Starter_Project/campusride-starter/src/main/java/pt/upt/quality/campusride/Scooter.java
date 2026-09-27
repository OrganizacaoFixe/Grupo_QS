package pt.upt.quality.campusride;

public class Scooter extends Vehicle implements Electric {
    private int batteryLevel;
    public static final double unlockFee = 1.00;
    public static final double feeUntil30 = 0.15;
    public static final double feeOver30 = 0.20;

    public Scooter(String id, int batteryLevel) {
        super(id);
        validateBattery(batteryLevel);
        this.batteryLevel = batteryLevel;
    }

    @Override
    public int getBatteryLevel() {
        return batteryLevel;
    }

    @Override
    public void charge(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Charge amount cannot be negative");
        }
        batteryLevel = Math.min(100, batteryLevel + amount);
    }

    @Override
    public double calculatePrice(int minutes) {
        validateMinutes(minutes);
        double n = 0.0;

        if (minutes > 30) {
            n = 30.0 * feeUntil30;
            minutes -= 30;
        } else {
            n = minutes * feeUntil30;
            minutes = 0;
        }

        return unlockFee + n + minutes * feeOver30;
    }

    private void validateBattery(int batteryLevel) {
        if (batteryLevel < 0 || batteryLevel > 100) {
            throw new IllegalArgumentException("Battery must be between 0 and 100");
        }
    }
}
