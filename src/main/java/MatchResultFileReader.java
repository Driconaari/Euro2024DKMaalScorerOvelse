import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MatchResultFileReader {
    private String fileName;

    public MatchResultFileReader(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
    }

    public List<MatchResult> readFile() throws IOException {
        List<MatchResult> matchResults = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                String teams = parts[0];
                String[] goalScorersArray = parts[1].split(",");
                List<String> goalScorers = new ArrayList<>();
                for (String scorer : goalScorersArray) {
                    goalScorers.add(scorer.trim());
                }
                matchResults.add(new MatchResult(teams, goalScorers));
            }
        }
        return matchResults;
    }
}
