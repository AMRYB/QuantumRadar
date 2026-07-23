import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Radar radar = new Radar();

        radar.addRule(new SeatBeltRule(100));

        radar.addRule(
                new SpeedRule(
                        CarType.TRUCK,
                        60,
                        300,
                        "Truck speed rule"
                )
        );

        radar.addRule(
                new SpeedRule(
                        CarType.PRIVATE,
                        80,
                        300,
                        "Private car speed rule"
                )
        );

        List<VehicleObservation> observations = List.of(

                new VehicleObservation(
                        "ABC1234",
                        LocalDateTime.now(),
                        CarType.PRIVATE,
                        94,
                        false
                ),

                new VehicleObservation(
                        "TRK5678",
                        LocalDateTime.now(),
                        CarType.TRUCK,
                        75,
                        true
                ),

                new VehicleObservation(
                        "PRV1001",
                        LocalDateTime.now(),
                        CarType.PRIVATE,
                        70,
                        true
                ),

                new VehicleObservation(
                        "TRK1002",
                        LocalDateTime.now(),
                        CarType.TRUCK,
                        55,
                        false
                ),

                new VehicleObservation(
                        "BUS1003",
                        LocalDateTime.now(),
                        CarType.BUS,
                        70,
                        false
                ),

                new VehicleObservation(
                        "PRV1004",
                        LocalDateTime.now(),
                        CarType.PRIVATE,
                        85,
                        true
                ),

                new VehicleObservation(
                        "TRK1005",
                        LocalDateTime.now(),
                        CarType.TRUCK,
                        90,
                        false
                ),

                new VehicleObservation(
                        "PRV1006",
                        LocalDateTime.now(),
                        CarType.PRIVATE,
                        60,
                        false
                ),

                new VehicleObservation(
                        "BUS1007",
                        LocalDateTime.now(),
                        CarType.BUS,
                        50,
                        true
                ),

                new VehicleObservation(
                        "PRV1008",
                        LocalDateTime.now(),
                        CarType.PRIVATE,
                        120,
                        false
                )
        );

        for (VehicleObservation observation : observations) {

            Fine fine = radar.observe(observation);

            if (fine != null) {
                fine.printFine();
            } else {
                System.out.println(
                        "No violations detected for car "
                                + observation.getPlateNumber()
                );
            }

            System.out.println();
        }

        System.out.println("All fines:");
        radar.printAllFines();

        System.out.println("\nViolated rules count:");
        radar.printViolatedRulesCount();
    }
}