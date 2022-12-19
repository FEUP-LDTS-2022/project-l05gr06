package tetrisRunner.controller.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import tetrisRunner.Game;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.menu.GameOver;
import tetrisRunner.model.menu.HighScore;
import tetrisRunner.states.GameOverState;
import tetrisRunner.states.SelectModeState;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

public class HighScoreControllerTest {
    private HighScoreController highScoreController;
    private HighScore highScore;
    private Game game;
    private List<GUI.ACTION> guiActions, letters;
    private List<String> lettersString;

    @BeforeEach
    public void helper(){
        highScore = Mockito.mock(HighScore.class);
        highScoreController = new HighScoreController(highScore);
        game = Mockito.mock(Game.class);
        Mockito.doCallRealMethod().when(highScore).setName("TA");
        Mockito.doCallRealMethod().when(highScore).setName("END");
        Mockito.doCallRealMethod().when(highScore).setName("");
        highScore.setName("");
        Mockito.doCallRealMethod().when(highScore).getName();
        guiActions = Arrays.asList(GUI.ACTION.ARROW_UP, GUI.ACTION.ARROW_DOWN, GUI.ACTION.SELECT);
        letters = Arrays.asList(GUI.ACTION.A, GUI.ACTION.B, GUI.ACTION.C,
                GUI.ACTION.D, GUI.ACTION.E, GUI.ACTION.F, GUI.ACTION.G, GUI.ACTION.H,
                GUI.ACTION.I, GUI.ACTION.J, GUI.ACTION.K, GUI.ACTION.L, GUI.ACTION.M,
                GUI.ACTION.N, GUI.ACTION.O, GUI.ACTION.P, GUI.ACTION.Q, GUI.ACTION.R,
                GUI.ACTION.S, GUI.ACTION.T, GUI.ACTION.U, GUI.ACTION.V, GUI.ACTION.W,
                GUI.ACTION.X, GUI.ACTION.Y, GUI.ACTION.Z);
        lettersString = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
                "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");
        for (String l: lettersString)
            Mockito.doCallRealMethod().when(highScore).setName(l);
    }

    @Test
    public void stepUpTest() throws IOException {
        highScoreController.step(game, guiActions.get(0),0);
        Mockito.verify(highScore, Mockito.times(1)).previousEntry();
    }

    @Test
    public void stepDownTest() throws IOException {
        highScoreController.step(game, guiActions.get(1),0);
        Mockito.verify(highScore, Mockito.times(1)).nextEntry();
    }
    @Test
    public void stepChangeNameTest() throws IOException {
        Mockito.when(highScore.isSelectedName()).thenReturn(true);
        int i=0;
        for (GUI.ACTION letter:letters){
            highScore.setName("");
            highScoreController.step(game, letter,0);
            Assertions.assertEquals(lettersString.get(i), highScore.getName());
            i++;
        }
    }
    @Test
    public void stepEraseLetterTest() throws IOException {
        Mockito.when(highScore.isSelectedName()).thenReturn(true);
        highScore.setName("TA");
        highScoreController.step(game, GUI.ACTION.BACKSPACE,0);
        Assertions.assertEquals("T", highScore.getName());
    }
    @Test
    public void stepUpdateClassicTest() throws IOException {
        highScore.setName("END");
        Mockito.when(highScore.isSelectedNext()).thenReturn(true);
        Mockito.when(highScore.isClassic()).thenReturn(true);
        highScoreController.step(game, guiActions.get(2),0);
        Mockito.verify(highScore,Mockito.times(1)).updateLeaderboardClassic("docs/leaderboard/classicLeaderboard.txt");
        Mockito.verify(game, Mockito.times(1)).setState(any(GameOverState.class));
    }
    @Test
    public void stepUpdateClimbingTest() throws IOException {
        highScore.setName("END");
        Mockito.when(highScore.isSelectedNext()).thenReturn(true);
        Mockito.when(highScore.isClassic()).thenReturn(false);
        highScoreController.step(game, guiActions.get(2),0);
        Mockito.verify(highScore,Mockito.times(1)).updateLeaderboardClimbing("docs/leaderboard/climbingLeaderboard.txt");
        Mockito.verify(game, Mockito.times(1)).setState(any(GameOverState.class));
    }
}
