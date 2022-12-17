package tetrisRunner.model.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LeaderboardTest {
    private Leaderboard leaderboard;
    @BeforeEach
    public void helper(){
        leaderboard = new Leaderboard();
    }
    @Test
    public void isSelectedChangeLeaderboardTest(){
        Assertions.assertTrue(leaderboard.isSelectedChangeLeaderboard());
        leaderboard.nextEntry();
        Assertions.assertFalse(leaderboard.isSelectedChangeLeaderboard());
    }
    @Test
    public void isSelectedReturnTest() {
        Assertions.assertFalse(leaderboard.isSelectedReturn());
        leaderboard.nextEntry();
        Assertions.assertTrue(leaderboard.isSelectedReturn());
    }
    @Test
    public void changeLeaderboardTest(){
        Assertions.assertEquals("Climbing ->", leaderboard.entries.get(0));
        leaderboard.changeLeaderboard();
        Assertions.assertEquals("<- Classic", leaderboard.entries.get(0));
        leaderboard.changeLeaderboard();
        Assertions.assertEquals("Climbing ->", leaderboard.entries.get(0));
    }
}
