package tetrisRunner.controller.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tetrisRunner.Game;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.menu.GameOver;
import tetrisRunner.model.menu.StartMenu;
import tetrisRunner.music.Music;
import tetrisRunner.states.SelectModeState;
import tetrisRunner.states.SettingsState;
import tetrisRunner.states.StartMenuState;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

public class GameOverControllerTest {
    private GameOverController gameOverController;
    private GameOver gameOver;
    private Game game;
    private List<GUI.ACTION> guiActions;

    @BeforeEach
    public void helper(){
        gameOver = Mockito.mock(GameOver.class);
        gameOverController = new GameOverController(gameOver);
        game = Mockito.mock(Game.class);
        guiActions = Arrays.asList(GUI.ACTION.ARROW_UP, GUI.ACTION.ARROW_DOWN, GUI.ACTION.SELECT);
    }

    @Test
    public void stepUpTest() throws IOException {
        gameOverController.step(game, guiActions.get(0),0);
        Mockito.verify(gameOver, Mockito.times(1)).previousEntry();
    }

    @Test
    public void stepDownTest() throws IOException {
        gameOverController.step(game, guiActions.get(1),0);
        Mockito.verify(gameOver, Mockito.times(1)).nextEntry();
    }

    @Test
    public void stepPlayAgainTest() throws IOException {
        Mockito.when(gameOver.isSelectedPlayAgain()).thenReturn(true);
        gameOverController.step(game, guiActions.get(2),0);
        Mockito.verify(game, Mockito.times(1)).setState(any(SelectModeState.class));
    }

    @Test
    public void stepSelectExitTest() throws IOException {
        Mockito.when(gameOver.isSelectedExit()).thenReturn(true);
        gameOverController.step(game, guiActions.get(2),0);
        Mockito.verify(game, Mockito.times(1)).setState(null);
    }

    @Test
    public void stepSelectMainMenuTest() throws IOException {
        Mockito.when(gameOver.isSelectedMainMenu()).thenReturn(true);
        gameOverController.step(game, guiActions.get(2),0);
        Mockito.verify(game, Mockito.times(1)).setState(any(StartMenuState.class));
    }
}
