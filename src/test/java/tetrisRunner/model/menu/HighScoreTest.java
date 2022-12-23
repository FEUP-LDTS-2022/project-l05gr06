package tetrisRunner.model.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.*;

public class HighScoreTest {
    private HighScore highScoreTest;
    private List<HighScore> highScoreListClassic, highScoreListClimbing;
    @BeforeEach
    public void helper(){
        highScoreTest = new HighScore(true,0);
        highScoreListClassic = Arrays.asList(new HighScore(true, 800),
                new HighScore(true, 5000), new HighScore(true, 700),
                new HighScore(true, 1200), new HighScore(true, 1200),
                new HighScore(true, 1000), new HighScore(true, 0),
                new HighScore(true, 1200));
        highScoreListClimbing = Arrays.asList(new HighScore(false, 800),
                new HighScore(false, 10), new HighScore(false, 200),
                new HighScore(false, 60), new HighScore(false, 100),
                new HighScore(false, 270), new HighScore(false, 10),
                new HighScore(false, 11));
    }
    @Test
    public void isSelectedNameTest() {
        Assertions.assertTrue(highScoreTest.isSelectedName());
        highScoreTest.nextEntry();
        Assertions.assertFalse(highScoreTest.isSelectedName());
    }
    @Test
    public void isSelectedNextTest() {
        Assertions.assertFalse(highScoreTest.isSelectedNext());
        highScoreTest.nextEntry();
        Assertions.assertTrue(highScoreTest.isSelectedNext());
    }
    @Test
    public void updateLeaderboardClassicTest() throws IOException {
        File file = File.createTempFile("testClassic",".txt");
        String path = file.getAbsolutePath();
        for (HighScore highscore:highScoreListClassic){
            highscore.updateLeaderboardClassic(path);
        }
        highScoreListClassic.sort((o1, o2) -> Double.compare(o2.score, o1.score));
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line = br.readLine();
        int i = 0;
        while (line != null){
            String[] parts = line.split("-");
            String leaderText = parts[1];
            leaderText = leaderText.trim();
            int leaderScore = Integer.parseInt(leaderText);
            Assertions.assertEquals(leaderScore,
                    (int) highScoreListClassic.get(i).score);
            i++;
            line = br.readLine();
        }
        file.deleteOnExit();
    }
    @Test
    public void updateLeaderboardClimbingTest() throws IOException {
        File file = File.createTempFile("testClimbing",".txt");
        String path = file.getAbsolutePath();
        for (HighScore highscore:highScoreListClimbing){
            highscore.updateLeaderboardClimbing(path);
        }
        highScoreListClimbing.sort(Comparator.comparingDouble(o -> o.score));
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line = br.readLine();
        int i = 0;
        while (line != null){
            String[] parts = line.split("-");
            String leaderText = parts[1];
            leaderText = leaderText.trim();
            String[] times = leaderText.split(":");
            int minutes = Integer.parseInt(times[0]);
            int seconds = Integer.parseInt(times[1]);
            int leaderScore = 60*minutes+seconds;
            Assertions.assertEquals(leaderScore,
                    (int) highScoreListClimbing.get(i).score);
            i++;
            line = br.readLine();
        }
        file.deleteOnExit();
    }
}
