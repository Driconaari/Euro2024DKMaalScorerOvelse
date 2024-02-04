import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class StatisticsTest {
    private List<MatchResult> matchResults;
    private Statistics statistics;

    @Before
    public void setUp() {
        matchResults = new ArrayList<>();
        matchResults.add(new MatchResult("San Marino-Denmark", Arrays.asList("Højlund", "Poulsen")));
        matchResults.add(new MatchResult("Denmark-Slovenia", Arrays.asList("Mæhle", "Delaney")));
        matchResults.add(new MatchResult("Northern Ireland-Denmark", new ArrayList<>()));

        statistics = new Statistics(matchResults);
    }

    @Test
    public void testGetGoalScorers() {
        Set<String> goalScorers = statistics.getGoalScorers();
        assertEquals(4, goalScorers.size());
        assertTrue(goalScorers.contains("Højlund"));
        assertTrue(goalScorers.contains("Poulsen"));
        assertTrue(goalScorers.contains("Mæhle"));
        assertTrue(goalScorers.contains("Delaney"));
    }

    @Test
    public void testGetGoalScorersWithTotals() {
        Map<String, Integer> goalScorersWithTotals = statistics.getGoalScorersWithTotals();
        assertEquals(4, goalScorersWithTotals.size());
        assertEquals(1, (int) goalScorersWithTotals.get("Højlund"));
        assertEquals(1, (int) goalScorersWithTotals.get("Poulsen"));
        assertEquals(1, (int) goalScorersWithTotals.get("Mæhle"));
        assertEquals(1, (int) goalScorersWithTotals.get("Delaney"));
    }

    @Test
    public void testGetNumberOfGoals() {
        assertEquals(1, statistics.getNumberOfGoals("Højlund"));
        assertEquals(0, statistics.getNumberOfGoals("Nonexistent"));
    }

    @Test

    public void testFileNotFoundException(){
    }


}
