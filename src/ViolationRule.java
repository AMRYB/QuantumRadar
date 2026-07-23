import java.util.Optional;

public interface ViolationRule {

    Optional<Violation> check(VehicleObservation observation);
}