package tetrisRunner.states;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tetrisRunner.controller.menu.LeaderboardController;
import tetrisRunner.model.menu.Leaderboard;
import tetrisRunner.viewer.menu.LeaderboardViewer;

public class LeaderboardStateTest {
    private LeaderboardState leaderboardState;
    private Leaderboard leaderboard;
    @BeforeEach
    public void helper(){
        leaderboard = new Leaderboard();
        leaderboardState = new LeaderboardState(leaderboard);
    }
    @Test
    public void getViewerTest(){
        Assertions.assertInstanceOf(LeaderboardViewer.class,leaderboardState.getViewer());
    }
    @Test
    public void getControllerTest(){
        Assertions.assertInstanceOf(LeaderboardController.class,leaderboardState.getController());
    }
}
