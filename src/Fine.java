import java.time.LocalDateTime;
import java.util.List;

public class Fine {

    private final String plateNumber;
    private final LocalDateTime date;
    private final List<Violation> violations;

    public Fine(
            String plateNumber,
            LocalDateTime date,
            List<Violation> violations) {

        this.plateNumber = plateNumber;
        this.date = date;
        this.violations = violations;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public List<Violation> getViolations() {
        return violations;
    }

    public double getTotalAmount() {
        double total = 0;

        for (Violation violation : violations) {
            total += violation.getFee();
        }

        return total;
    }

    public void printFine() {

        System.out.println("Traffic fine for car " + plateNumber);

        System.out.printf(
                "Total amount: %.0f EGP%n",
                getTotalAmount()
        );

        System.out.println("Violations:");

        for (Violation violation : violations) {

            System.out.printf(
                    "- %s : %.0f EGP%n",
                    violation.getDescription(),
                    violation.getFee()
            );
        }
    }
}