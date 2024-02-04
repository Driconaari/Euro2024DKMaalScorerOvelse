import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String fileName = "Euro2024QualifyingRound.csv";
        Statistics statistics = new Statistics(fileName);

        Set<String> goalScorers = statistics.getGoalScorers();
        Map<String, Integer> goalScorersWithTotals = statistics.getGoalScorersWithTotals();
        int numberOfGoalsForPlayer = statistics.getNumberOfGoals("Højlund");

        System.out.println("Goal Scorers: " + goalScorers);
        System.out.println("Goal Scorers with Totals: " + goalScorersWithTotals);
        System.out.println("Number of Goals for Højlund: " + numberOfGoalsForPlayer);
    }
}
