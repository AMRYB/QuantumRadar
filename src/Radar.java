import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Radar {

    private final List<ViolationRule> rules;
    private final List<Fine> fines;

    public Radar() {
        rules = new ArrayList<>();
        fines = new ArrayList<>();
    }

    public void addRule(ViolationRule rule) {
        rules.add(rule);
    }

    public Fine observe(VehicleObservation observation) {

        List<Violation> detectedViolations = new ArrayList<>();

        for (ViolationRule rule : rules) {

            rule.check(observation)
                    .ifPresent(detectedViolations::add);
        }

        if (detectedViolations.isEmpty()) {
            return null;
        }

        Fine fine = new Fine(
                observation.getPlateNumber(),
                observation.getDate(),
                detectedViolations
        );

        fines.add(fine);

        return fine;
    }

    public void printAllFines() {

        if (fines.isEmpty()) {
            System.out.println("No fines found.");
            return;
        }

        for (Fine fine : fines) {

            System.out.printf(
                    "%s : %.0f EGP%n",
                    fine.getPlateNumber(),
                    fine.getTotalAmount()
            );
        }
    }

    public Map<String, Integer> getViolatedRulesCount() {

        Map<String, Integer> ruleCounts = new LinkedHashMap<>();

        for (Fine fine : fines) {

            for (Violation violation : fine.getViolations()) {

                String ruleName = violation.getRuleName();

                ruleCounts.put(
                        ruleName,
                        ruleCounts.getOrDefault(ruleName, 0) + 1
                );
            }
        }

        return ruleCounts;
    }

    public void printViolatedRulesCount() {

        Map<String, Integer> ruleCounts =
                getViolatedRulesCount();

        if (ruleCounts.isEmpty()) {
            System.out.println("No violated rules found.");
            return;
        }

        for (Map.Entry<String, Integer> entry
                : ruleCounts.entrySet()) {

            System.out.println(
                    entry.getKey() + " : " + entry.getValue()
            );
        }
    }
}