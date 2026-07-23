import java.time.LocalDateTime;

public class VehicleObservation {

    private final String plateNumber;
    private final LocalDateTime date;
    private final CarType carType;
    private final int speed;
    private final boolean seatBeltFastened;

    public VehicleObservation(
            String plateNumber,
            LocalDateTime date,
            CarType carType,
            int speed,
            boolean seatBeltFastened) {

        this.plateNumber = plateNumber;
        this.date = date;
        this.carType = carType;
        this.speed = speed;
        this.seatBeltFastened = seatBeltFastened;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public CarType getCarType() {
        return carType;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isSeatBeltFastened() {
        return seatBeltFastened;
    }
}