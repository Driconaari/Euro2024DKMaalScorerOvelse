import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Statistics {
    private List<MatchResult> matchResults;

    // Default constructor used in production
    public Statistics(String filename) {
        try {
            MatchResultFileReader reader = new MatchResultFileReader(filename);
            this.matchResults = reader.readFile();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
            this.matchResults = new ArrayList<>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Constructor for testing with preloaded match results
    public Statistics(List<MatchResult> matchResults) {
        this.matchResults = matchResults;
    }

    public Set<String> getGoalScorers() {
        Set<String> goalScorers = new HashSet<>();
        for (MatchResult matchResult : matchResults) {
            goalScorers.addAll(matchResult.getGoalScorers());
        }
        return goalScorers;
    }

    public Map<String, Integer> getGoalScorersWithTotals() {
        Map<String, Integer> goalScorersWithTotals = new HashMap<>();
        for (MatchResult matchResult : matchResults) {
            for (String scorer : matchResult.getGoalScorers()) {
                goalScorersWithTotals.merge(scorer, 1, Integer::sum);
            }
        }
        return goalScorersWithTotals;
    }

    public int getNumberOfGoals(String goalScorer) {
        int totalGoals = 0;
        for (MatchResult matchResult : matchResults) {
            totalGoals += matchResult.getGoalScorers().stream().filter(s -> s.equals(goalScorer)).count();
        }
        return totalGoals;
    }
}
