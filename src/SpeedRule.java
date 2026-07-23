import java.util.Optional;

public class SpeedRule implements ViolationRule {

    private final CarType applicableCarType;
    private final int maximumSpeed;
    private final double fee;
    private final String ruleName;

    public SpeedRule(
            CarType applicableCarType,
            int maximumSpeed,
            double fee,
            String ruleName) {

        this.applicableCarType = applicableCarType;
        this.maximumSpeed = maximumSpeed;
        this.fee = fee;
        this.ruleName = ruleName;
    }

    @Override
    public Optional<Violation> check(VehicleObservation observation) {

        boolean sameCarType =
                observation.getCarType() == applicableCarType;

        boolean exceededSpeed =
                observation.getSpeed() > maximumSpeed;

        if (sameCarType && exceededSpeed) {

            String description =
                    "speed of " + observation.getSpeed()
                            + " exceeded max allowed "
                            + maximumSpeed;

            Violation violation = new Violation(
                    ruleName,
                    description,
                    fee
            );

            return Optional.of(violation);
        }

        return Optional.empty();
    }
}