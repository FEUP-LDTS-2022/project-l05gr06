package tetrisRunner.controller.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import tetrisRunner.Game;
import tetrisRunner.gui.GUI;
import tetrisRunner.model.game.layout.Layout;
import tetrisRunner.model.menu.Pause;
import tetrisRunner.model.menu.SelectMode;
import tetrisRunner.music.Music;
import tetrisRunner.states.GameState;
import tetrisRunner.states.SettingsState;
import tetrisRunner.states.StartMenuState;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

public class PauseControllerTest {
    private PauseController pauseController;
    private Pause pause;
    private Game game;
    private List<GUI.ACTION> guiActions;

    @BeforeEach
    public void helper(){
        pause = Mockito.mock(Pause.class);
        pauseController = new PauseController(pause);
        game = Mockito.mock(Game.class);
        Music music = Mockito.mock(Music.class);
        Mockito.when(pauseController.getModel().getGameState()).thenReturn(new GameState(new Layout(10,10)));
        Mockito.when(game.getMusic()).thenReturn(music);
        Mockito.when(music.isMuted()).thenReturn(true);
        guiActions = Arrays.asList(GUI.ACTION.UP, GUI.ACTION.DOWN, GUI.ACTION.SELECT);
    }

    @Test
    public void stepUpTest() throws IOException {
        pauseController.step(game, guiActions.get(0),0);
        Mockito.verify(pause, Mockito.times(1)).previousEntry();
    }

    @Test
    public void stepDownTest() throws IOException {
        pauseController.step(game, guiActions.get(1),0);
        Mockito.verify(pause, Mockito.times(1)).nextEntry();
    }

    @Test
    public void stepReturnToGame() throws IOException {
        Mockito.when(pause.isSelectedGame()).thenReturn(true);
        pauseController.step(game, guiActions.get(2),0);
        Mockito.verify(game, Mockito.times(1)).setState(any(GameState.class));
    }

    @Test
    public void stepSelectedMenu() throws IOException {
        Mockito.when(pause.isSelectedMenu()).thenReturn(true);
        pauseController.step(game, guiActions.get(2),0);
        Mockito.verify(game, Mockito.times(1)).setState(any(StartMenuState.class));
    }

    @Test
    public void stepSelectedSettings() throws IOException {
        Mockito.when(pause.isSelectedSettings()).thenReturn(true);
        pauseController.step(game, guiActions.get(2),0);
        Mockito.verify(game, Mockito.times(1)).setState(any(SettingsState.class));
    }

    @Test
    public void stepSelectedExit() throws IOException {
        Mockito.when(pause.isSelectedExit()).thenReturn(true);
        pauseController.step(game, guiActions.get(2),0);
        Mockito.verify(game, Mockito.times(1)).setState(null);
    }
}
