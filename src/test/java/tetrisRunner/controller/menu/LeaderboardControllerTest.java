package tetrisRunner.controller.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tetrisRunner.Game;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.menu.GameOver;
import tetrisRunner.model.menu.Leaderboard;
import tetrisRunner.states.SelectModeState;
import tetrisRunner.states.StartMenuState;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

public class LeaderboardControllerTest {
    private LeaderboardController leaderboardController;
    private Leaderboard leaderboard;
    private Game game;
    private List<GUI.ACTION> guiActions;

    @BeforeEach
    public void helper(){
        leaderboard = Mockito.mock(Leaderboard.class);
        leaderboardController = new LeaderboardController(leaderboard);
        game = Mockito.mock(Game.class);
        guiActions = Arrays.asList(GUI.ACTION.ARROW_UP, GUI.ACTION.ARROW_DOWN, GUI.ACTION.SELECT);
    }

    @Test
    public void stepUpTest() throws IOException {
        leaderboardController.step(game, guiActions.get(0),0);
        Mockito.verify(leaderboard, Mockito.times(1)).previousEntry();
    }

    @Test
    public void stepDownTest() throws IOException {
        leaderboardController.step(game, guiActions.get(1),0);
        Mockito.verify(leaderboard, Mockito.times(1)).nextEntry();
    }

    @Test
    public void stepChangeLeaderboardTest() throws IOException {
        Mockito.when(leaderboard.isSelectedChangeLeaderboard()).thenReturn(true);
        leaderboardController.step(game, guiActions.get(2),0);
        Mockito.verify(leaderboard, Mockito.times(1)).changeLeaderboard();
    }

    @Test
    public void stepSelectReturnTest() throws IOException {
        Mockito.when(leaderboard.isSelectedReturn()).thenReturn(true);
        leaderboardController.step(game, guiActions.get(2),0);
        Mockito.verify(game, Mockito.times(1)).setState(any(StartMenuState.class));
    }
}
