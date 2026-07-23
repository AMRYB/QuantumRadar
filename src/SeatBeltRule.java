import java.util.Optional;

public class SeatBeltRule implements ViolationRule {

    private final double fee;

    public SeatBeltRule(double fee) {
        this.fee = fee;
    }

    @Override
    public Optional<Violation> check(VehicleObservation observation) {

        if (!observation.isSeatBeltFastened()) {

            Violation violation = new Violation(
                    "Seatbelt rule",
                    "Seatbelt not fastened",
                    fee
            );

            return Optional.of(violation);
        }

        return Optional.empty();
    }
}